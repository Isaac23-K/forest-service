import org.sql2o.*;

public class DB {
    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://ec2-18-204-74-74.compute-1.amazonaws.com:5432/d91jdsqil7mrgu", "ojsuuegopxnauh", "90866582875eb5fd50c241c2ca4d4acb7fceff9b3c048b69b534cd8f1c4a286d");


   // public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "isaac", "kaptoge");
}