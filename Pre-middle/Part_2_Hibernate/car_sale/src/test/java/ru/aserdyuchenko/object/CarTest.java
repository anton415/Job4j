package ru.aserdyuchenko.object;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CarTest {

    @Test
    public void whenCreateSimpleObject() {
        Car car = new Car("Renault", "Sandero", 2011, 121000L, "white");
        assertThat(car.toString(), is("Renault, Sandero, 2011, 121000, white"));
    }
}