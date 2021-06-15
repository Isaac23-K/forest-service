import org.junit.rules.ExternalResource;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://ec2-18-204-74-74.compute-1.amazonaws.com:5432/d91jdsqil7mrgu","ojsuuegopxnauh","90866582875eb5fd50c241c2ca4d4acb7fceff9b3c048b69b534cd8f1c4a286d");
        // DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test", "isaac", "kaptoge");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String deleteSightingQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteSightingQuery).executeUpdate();
        }
    }

}