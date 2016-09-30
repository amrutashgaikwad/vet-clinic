package serenitylabs.tutorials.vetclinic.screenplay;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import net.serenitybdd.junit.runners.SerenityRunner;
import serenitylabs.tutorials.vetclinic.model.Pet;
import serenitylabs.tutorials.vetclinic.model.PetHotel;
import serenitylabs.tutorials.vetclinic.screenplay.tasks.CheckIn;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

/**
 * Created by agaikwad on 9/22/2016.
 */

@RunWith(SerenityRunner.class)
public class WhenCheckingInToThePetHotel {
    @Test
    public void petra_books_her_pet_cat_into_the_hotel()
    {
        //GIVEN
        Actor petra = Actor.named("Petra the pet owner");
        Pet ginger = Pet.cat().named("Ginger");
        PetHotel petHotel = PetHotel.called("Le Meridian");

        //WHEN
        petra.attemptsTo(
                //new checkIn(ginger, petHotel)
                CheckIn.aPet(ginger).into(petHotel)
        );

        //THEN
        assertThat(petHotel.getPets(), hasItem(ginger));

    }
}
