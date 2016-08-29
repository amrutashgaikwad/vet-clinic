package serenitylabs.tutorials.vetclinic.collections.exercises;

import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Breed;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class WhenWorkingWithAPetMap {

    @Test
    public void pets_can_be_found_by_their_name() {
    	//SET
        Map<String, Pet> pets = new HashMap<>();

        //SET
        Pet fido = Pet.dog().named("Fido");

        //WHEN
        pets.put("Fido", fido);
        
        //THEN
        assertThat(pets.get("Fido"), is( fido ) );
    }

    @Test
    public void should_be_able_to_get_a_default_value_if_no_matching_key_is_present() {
    	//SET
        Map<String, Pet> pets = new HashMap<>();

        //SET
        Pet fido = Pet.dog().named("Fido");
        Pet stray = Pet.dog().named("Stray");

        //SET
        pets.put("Fido", fido);
        pets.put("Stray", stray);
        
        //WHEN
        Pet retrievedPet = pets.getOrDefault("Rover", stray);

        //THEN
        assertThat( retrievedPet, is( stray ) );
    }

    @Test
    public void the_map_keys_should_be_the_pet_names() {
    	//SET
        Map<String, Pet> pets = new HashMap<>();

        //SET
        Pet fido = Pet.dog().named("Fido");
        Pet felix = Pet.cat().named("Felix");

        //THEN
        pets.put("Fido", fido);
        pets.put("Felix", felix);

    }

    @Test
    public void the_map_should_store_pets_in_alphabetical_order() {
    	//SET
        //Instantiate the correct type of Map
        NavigableMap<String, Pet> pets = new TreeMap<>();

        //WHEN
        pets.put("Rover", Pet.dog().named("Rover"));
        pets.put("Felix", Pet.cat().named("Felix"));
        pets.put("Spot", Pet.cat().named("Spot"));

        //THEN
        assertThat(pets.keySet(), contains("Felix","Rover","Spot"));
    }

    @Test
    public void the_map_should_store_pets_in_the_order_they_where_added() {
        //SET
    	//Instantiate the correct type of Map
        Map<String, Pet> pets =  new LinkedHashMap<>();

        //WHEN
        pets.put("Spot", Pet.cat().named("Spot"));
        pets.put("Rover", Pet.dog().named("Rover"));
        pets.put("Felix", Pet.cat().named("Felix"));
        pets.put("Fido", Pet.cat().named("Fido"));

        //THEN
        assertThat(pets.keySet(), contains("Spot", "Rover","Felix", "Fido"));
    }

    @Test
    public void the_map_should_store_pet_leaders_by_breed() {
        //SET
    	//Create an EnumMap to define a pet leader for each breed
        EnumMap<Breed, Pet> petLeaders =  new EnumMap<>(Breed.class);

        //WHEN
        petLeaders.put(Breed.Cat, Pet.cat().named("Felix"));
        petLeaders.put(Breed.Dog, Pet.dog().named("Lassie"));
        petLeaders.put(Breed.Rabbit, Pet.cat().named("Hazel"));

        //THEN
        assertThat(petLeaders.get(Breed.Dog).getName(), equalTo("Lassie"));
    }

}
