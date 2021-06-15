import java.sql.Timestamp;
import java.util.List;
import org.sql2o.*;
import java.util.Date;

public class Sighting {
    private String ranger ;
    private int animal_id;
    private String location;
    //private Date date = new Date();
    private Timestamp time;
    private int id;

    public Sighting(String ranger,String location, int animal_id){
        this.animal_id = animal_id;
        this.location = location;
        this.ranger = ranger;
        // this.time = new Timestamp(date.getTime());
    }

    public String getRanger(){
        return ranger;
    }
    public String getLocation(){
        return location;
    }
    public int getAnimal_id(){
        return animal_id;
    }
    public void save(){
        try (Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO sighting(ranger, animal_id, location , time) VALUES (:ranger, :animal_id, :location, :time)";
            con.createQuery(sql)
                    .addParameter("ranger",this.ranger)
                    .addParameter("animal_id",this.animal_id)
                    .addParameter("location",this.location)
                    .executeUpdate();
        }
    }
    public static List<Sighting> all (){
        String sql = "SELECT * FROM sighting";
        try (Connection con = DB.sql2o.open()){
            return con.createQuery(sql)
                    .executeAndFetch(Sighting.class);
        }
    }
}