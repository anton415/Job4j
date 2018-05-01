package ru.aserdyuchenko.todo_list.models;

import java.util.Date;

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
    private Date created;
    /**
     * If item done.
     */
    private boolean done;

    public Item() {
        this.description = "";
        this.created = new Date();
        this.done = false;
    }

    /**
     * Constructor.
     * @param description - task`s description.
     */
    public Item(String description) {
        this.description = description;
        this.created = new Date();
        this.done = false;
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

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}