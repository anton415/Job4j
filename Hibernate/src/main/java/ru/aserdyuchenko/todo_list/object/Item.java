package ru.aserdyuchenko.todo_list.object;

import java.util.Date;

/**
 * @author Anton Serdyuchenko   (a.serdyuchenko@yahoo.com)
 * @since 27.04.2018
 */
public class Item {
    private int id;
    private String description;
    private Date created;
    private boolean done;

    /**
     * Constructor.
     * @param description - task`s description.
     */
    public Item(String description) {
        this.description = description;
        this.created = new Date();
        this.done = false;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", done=" + done +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
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
