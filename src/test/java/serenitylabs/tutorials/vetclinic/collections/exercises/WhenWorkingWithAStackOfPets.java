package serenitylabs.tutorials.vetclinic.collections.exercises;

import org.junit.Test;
import serenitylabs.tutorials.vetclinic.Pet;

import java.util.Deque;
import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WhenWorkingWithAStackOfPets {

    @Test
    public void should_store_pets_in_a_stack() {

    	//SET
        Deque<Pet> pets = new LinkedList<>();

        //THEN
        pets.push(Pet.cat().named("Felix"));
        pets.push(Pet.dog().named("Fido"));

        //THEN
        // TODO: Retrieve the last pet put on the list
        Pet lastPet = pets.pollFirst();

        //VERIFY
        assertThat(lastPet.getName(),equalTo("Fido"));
        assertThat(pets.size(), equalTo(1));
    }

    @Test
    public void should_see_the_next_item_in_a_stack() {

    	//SET
        Deque<Pet> pets = new LinkedList<>();

        //THEN
        pets.push(Pet.cat().named("Felix"));
        pets.push(Pet.dog().named("Fido"));

        //THEN
        // TODO: Retrieve the last pet put on the list
        Pet lastPet = pets.peekFirst();

        //VERIFY
        assertThat(lastPet.getName(),equalTo("Fido"));
        assertThat(pets.size(), equalTo(2));
    }
}
