package serenitylabs.tutorials.vetclinic.collections.exercises;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

import serenitylabs.tutorials.vetclinic.Pet;

public class WhenWorkingWithAPetQueue {

    @Test
    public void should_add_Fido_to_the_end_of_the_queue() {
    	//SET
        Queue<Pet> waitingList = new LinkedList<>();

        //WHEN
        waitingList.add(Pet.cat().named("Felix"));
        waitingList.add(Pet.dog().named("Fido"));

        //THEN
        Pet nextInLine = waitingList.poll();

        //VERIFY
        assertThat( waitingList.poll(), is( Pet.dog().named("Fido") ) );
    }

    @Test
    public void should_see_who_is_at_the_top_of_the_queue_without_removing_it() {
    	//SET
        Queue<Pet> waitingList = new LinkedList<>();

        //WHEN
        waitingList.add(Pet.cat().named("Felix"));
        waitingList.add(Pet.dog().named("Fido"));

        //THEN
        Pet nextInLine = waitingList.peek();

        //VERIFY
        assertThat( nextInLine, is(Pet.cat().named("Felix")) );
    }


}
