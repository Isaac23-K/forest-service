import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        staticFileLocation("/public");


        //get sightings
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());



        // for the success message
        get("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = Animal.all();
            model.put("animals", animals);
            return new ModelAndView(model, "homepage.hbs");
        }, new HandlebarsTemplateEngine());


        //String name, String endangered, String health , String age
        post("/show", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animals = Animal.all();
            String name = request.queryParams("rangerName");
            String endangered = request.queryParams("animal");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            Animal animal = new Animal(name, endangered, health, age);
            animal.save();
            model.put("animals",animals);
//            Sighting newSighting = new Sighting(ranger, location, newAnimal.getId());
//            model.put("ranger", newSighting.getRanger());
//            model.put("location",newSighting.getLocation());
//            newSighting.save();
//            model.put("animals",Animal.all());
//            model.put("sighting",Sighting.all());
//            model.put("AnimalClass",Animal.class);
//            System.out.println(newAnimal);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        // String ranger,String location, int animal_id
    }
}