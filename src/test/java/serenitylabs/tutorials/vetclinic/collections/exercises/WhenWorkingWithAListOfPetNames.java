package serenitylabs.tutorials.vetclinic.collections.exercises;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.assertThat;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;


public class WhenWorkingWithAListOfPetNames {

    @Test
    public void should_add_Fido_in_list_of_pets() {
    	//WHEN
        List<String> names = Lists.newArrayList();

        //THEN
        names.add("Felix");

        //VERIFY
        assertThat(names, hasItems("Felix"));
    }

    @Test
    public void should_remove_Fido_from_the_list_of_pets() {
    	//WHEN
        List<String> names = Lists.newArrayList("Felix","Fido","Brad");
        
        //THEN
        names.remove(1);

        //VERIFY
        assertThat(names, not( contains("Fido") ) );
    }

    @Test
    public void should_remove_first_pet_from_list_of_pets() {
        //WHEN
    	List<String> names = Lists.newArrayList("Felix","Fido","Brad");
    	
    	//THEN
        names.remove(0);
        
        //VERIFY
        assertThat(names, not( contains("Felix") ) );
    }

    @Test
    public void should_make_a_list_of_cats_and_dogs() {
    	//WHEN
        List<String> cats = Lists.newArrayList("Felix","Brad");
        List<String> dogs = Lists.newArrayList("Fido","Richi");
        List<String> catsAndDogs = Lists.newArrayList();

        //THEN
        catsAndDogs.addAll(cats);
        catsAndDogs.addAll(dogs);
        
        //VERIFY
        assertThat(catsAndDogs, hasItems("Felix","Brad","Fido","Richi"));
    }

    @Test
    public void should_put_the_dogs_among_the_cats() {
    	//WHEN
        List<String> cats = Lists.newArrayList("Felix","Brad");
        List<String> dogs = Lists.newArrayList("Fido","Richi");
        List<String> catsAndDogs = new ArrayList<>();
        
        //THEN
        catsAndDogs.add(0, cats.get(0));
        catsAndDogs.addAll(dogs);
        catsAndDogs.add(3, cats.get(1));
        
        //VERIFY
        assertThat(catsAndDogs, hasItems("Felix","Fido","Richi","Brad"));
    }

    @Test
    public void should_organise_pets_in_alphabetical_order() {
    	//WHEN
        List<String> pets = Lists.newArrayList("Felix","Brad","Fido","Richi");

        //THEN
        Collections.sort(pets, Collator.getInstance());
        
        //VERIFY
        assertThat(pets, contains("Brad","Felix","Fido","Richi"));
    }

    @Test
    public void should_organise_pets_in_reverse_alphabetical_order() {
    	//WHEN
        List<String> pets = Lists.newArrayList("Felix","Brad","Fido","Richi");
        

        //THEN
        Collections.sort(pets, Collator.getInstance().reversed());
        //Collections.reverse(pets);
        
        //VERIFY
        assertThat(pets, contains("Richi","Fido","Felix","Brad"));
    }

    @Test
    public void should_organise_pets_by_name_length() {
    	//WHEN
        List<String> pets = Lists.newArrayList("Felix","Gerron","Brad");

        //THEN
        pets.sort(Comparator.comparing(String::length));

        //VERIFY
        assertThat(pets, contains("Brad","Felix","Gerron"));
    }

}
