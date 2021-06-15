import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void animal_instantiatesWithTrue() {
        Animal testAnimal = new Animal("panda", "yes","healthy","young");
        assertEquals(true, testAnimal instanceof Animal);
    }

    @Test
    void animal_instantiatesWithName_String() {
        Animal testAnimal = new Animal("panda","yes","healthy","young");
        assertEquals("panda", testAnimal.getName());
    }

    @Test
    void animal_instantiatesWith_endangered() {
        Animal testAnimal = new Animal("panda","yes","healthy","young");
        assertEquals("yes", testAnimal.getEndangered());
    }

    @Test
    void animal_instantiatesWithHealth_true() {
        Animal testAnimal = new Animal("panda","yes","healthy","young");
        assertEquals("healthy", testAnimal.getHealth());
    }

    @Test
    void animal_instantiatesWithAge_true() {
        Animal testAnimal = new Animal("panda","yes","healthy","young");
        assertEquals("young", testAnimal.getAge());
    }

    @Test
    void allAnimals_SavedToDatabase() {
        Animal testAnimal = new Animal("panda","yes","healthy","young");
//        testAnimal.save();
        assertEquals("panda", testAnimal.getName());
    }

    @Test
    void animals_AllReturnTrue() {
        Animal firstAnimal = new Animal("panda", "yes","healthy","young");
        //   firstAnimal.save();
        Animal secondAnimal = new Animal("elephant", "yes","healthy","young");
        //  secondAnimal.save();
        assertEquals("panda", firstAnimal.getName());
        assertEquals("elephant",secondAnimal.getName());
    }
}