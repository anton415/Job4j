package ru.aserdyuchenko.object;

import java.util.ArrayList;

public class User {
    private Integer id;
    private String name;
    private ArrayList<Car> cars = new ArrayList<Car>(3);

    public User(String name) {
        // TODO: Add id's generation.
        this.id = 0;
        this.name = name;
    }

    public User(String name, Car car) {
        // TODO: Add id's generation.
        this.id = 0;
        this.name = name;
        this.cars.add(car);
    }

    public User(String name, Car... cars) {
        // TODO: Add id's generation.
        this.id = 0;
        this.name = name;
        for (Car car : cars) {
            this.cars.add(car);
        }
    }

    public User(String name, ArrayList<Car> cars) {
        // TODO: Add id's generation.
        this.id = 0;
        this.name = name;
         this.cars = cars;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        String userToString;
        if(this.cars.isEmpty()) {
            userToString = name;
        } else {
            userToString = name + ", cars=" + cars;
        }
        return userToString;
    }
}
