package ru.aserdyuchenko.object;

public class Poster {
    private int id;
    private Car car;

    public Poster(Car car) {
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
