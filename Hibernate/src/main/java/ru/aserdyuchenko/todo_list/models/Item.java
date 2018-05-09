package ru.aserdyuchenko.todo_list.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

/**
 * @author Anton Serdyuchenko   (a.serdyuchenko@yahoo.com)
 * @since 27.04.2018
 */
public class Item {
    /**
     * Item`s id.
     */
    private int id;
    /**
     * Item`s description.
     */
    private String description;
    /**
     * Date when item was created.
     */
    private Timestamp created;
    /**
     * If item done.
     */
    private boolean done;

    public Item() {
        this.description = "";
        this.created = new Timestamp(System.currentTimeMillis());
        this.done = false;
    }

    /**
     * Constructor.

     * @param description - task`s description.
     */
    public Item(String description) {
        this.description = description;
        this.created = new Timestamp(System.currentTimeMillis());
        this.done = false;
    }

    @Override
    public String toString() {
        return id + ", '" + description + '\'' +
                ", " + created +
                ", " + done;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id &&
                done == item.done &&
                Objects.equals(description, item.description) &&
                Objects.equals(created, item.created);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, description, created, done);
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}