package ru.aserdyuchenko.todo_list.object;

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
        return "Item{"
                +
                "id=" + id
                +
                ", description='" + description + '\''
                +
                ", created=" + created
                +
                ", done=" + done
                +
                '}';
    }

    /**
     * Get item`s id.
     * @return item`s id.
     */
    public int getId() {
        return id;
    }

    /**
     * Set item`s id.
     * @param id - item`s id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get item`s description.
     * @return item`s description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description for item.
     * @param description - item`s description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get date, when item was created.
     * @return date when item was created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Set create date.
     * @param created - created date.
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * Check if item done.
     * @return true if done.
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Set done value.
     * @param done - true if item done.
     */
    public void setDone(boolean done) {
        this.done = done;
    }
}