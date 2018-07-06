package ru.aserdyuchenko.object;

import java.util.Date;

/**
 * Car object.
 * @author Anton Serdyuchenko.
 * @since 19.05.2018
 */
public class Car {
    private Integer id;
    private String mark;
    private String model;
    private Integer yearOfManufacture;
    private Long mileage;
    private String color;

    public Car(String mark, String model, Integer yearOfManufacture, Long mileage, String color) {
        // TODO: Generate id.
        this.id = 0;
        this.mark = mark;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.mileage = mileage;
        this.color = color;
    }

    public Integer getId() {
        return this.id;
    }

    public String getMark() {
        return this.mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearOfManufacture() {
        return this.yearOfManufacture;
    }

    public void setYearOfManufacture(Integer yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Long getMileage() {
        return this.mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return getMark() + ", " + getModel() + ", " + getYearOfManufacture() + ", " + getMileage() + ", " + getColor();
    }
}
