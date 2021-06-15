import org.sql2o.Connection;
import org.sql2o.Sql2oException;

import java.util.List;


public class Animal implements DatabaseManagement {
    private String name ;
    private String endangered;
    private String health;
    private String age ;
    private int id ;

    public Animal(String name, String endangered, String health , String age ) {
        this.age = age;
        this.endangered = endangered ;
        this.health =  health ;
        this.name = name ;
        this.id = id ;
    }

    public String getName(){
        return name ;
    }
    public String getEndangered(){
        return endangered;
    }
    public String getHealth(){
        return health;
    }
    public String getAge(){
        return age;
    }
    public int getId(){
        return id;
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO animals(name, endangered ,health, age ) VALUES (:name , :endangered , :health , :age)";
            con.createQuery(sql)
                    .addParameter("name", this.name)
                    .addParameter("age", this.age)
                    .addParameter("health", this.health)
                    .addParameter("endangered", this.endangered)
                    .executeUpdate();
        }
    }

    public void update( String name, String endangered, String health, String age) {
        try (Connection con = (Connection) DB.sql2o.open()) {
            if (endangered.equals("")) {
                throw new IllegalArgumentException("All fields must be filled");
            }
            if (endangered == "endangered") {
                if (health.equals("") || age.equals("")) {
                    throw new IllegalArgumentException("All fields must be filled");
                }
                String sql = "UPDATE animals SET type=:endangered,health=:health,age=:age WHERE id=:id";
                con.createQuery(sql)
                        .addParameter("type", endangered)
                        .addParameter("health", health)
                        .addParameter("age", age)
                        .addParameter("id", this.id)
                        .executeUpdate();
            } else {
                String sql = "UPDATE animals SET type=:type,health=:health,age=:age WHERE id=:id";
                con.createQuery(sql)
                        .addParameter("type", endangered)
                        .addParameter("health", "")
                        .addParameter("age", "")
                        .addParameter("id", this.id)
                        .executeUpdate();
            }
        } catch (Sql2oException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void delete() {

    }

    public static List<Animal> all(){
        String sql = "SELECT * FROM animals";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql)
                    .executeAndFetch(Animal.class);

        }

    }

}