package ru.aserdyuchenko.object;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PosterTest {

    @Test
    public void whenCreatePoster() {
        User anton = new User("Anton");
        Car car = new Car("Renault", "Sandero", 2011, 121000L, "white");

        anton.createPoster(car);

        assertThat(anton.getInfoAboutPoster(0), is("Anton : Renault, Sandero, 2011, 121000, white"));
    }

}