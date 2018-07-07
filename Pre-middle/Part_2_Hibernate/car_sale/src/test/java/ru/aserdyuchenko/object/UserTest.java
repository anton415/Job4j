package ru.aserdyuchenko.object;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void whenCreateSimpleUserObjectAndGetLikeStringWhenUserHasNotCar() {
        User user = new User("Anton");
        assertThat(user.toString(), is("Anton"));
    }

    @Test
    public void whenCreateSimpleUserObjectAndGetLikeStringWhenUserHasCar() {
        Car car = new Car("Renault", "Sandero", 2011, 121000L, "white");
        User user = new User("Anton", car);
        assertThat(user.toString(), is("Anton, cars=[Renault, Sandero, 2011, 121000, white]"));
    }

    @Test
    public void whenCreateSimpleUserObjectAndGetLikeStringWhenUserHasTwoCars() {
        Car sandero = new Car("Renault", "Sandero", 2011, 121000L, "white");
        Car huracan = new Car("Lamborghini", "Huracan", 2015, 19000L, "orange");
        User user = new User("Anton", sandero, huracan);
        assertThat(user.toString(),
                is("Anton, cars=[Renault, Sandero, 2011, 121000, white, Lamborghini, Huracan, 2015, 19000, orange]"));
    }

    @Test
    public void whenCreateSimpleUserObjectAndGetLikeStringWhenUserHasTwoCarsLikeList() {
        Car sandero = new Car("Renault", "Sandero", 2011, 121000L, "white");
        Car huracan = new Car("Lamborghini", "Huracan", 2015, 19000L, "orange");
        ArrayList<Car> cars = new ArrayList<Car>(Arrays.asList(sandero, huracan));
        User user = new User("Anton", cars);
        assertThat(user.toString(),
                is("Anton, cars=[Renault, Sandero, 2011, 121000, white, Lamborghini, Huracan, 2015, 19000, orange]"));
    }
}