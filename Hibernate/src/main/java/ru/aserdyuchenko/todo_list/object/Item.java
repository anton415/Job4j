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
     * Check if item done.
     * @return true if done.
     */
    public boolean isDone() {
        return done;
    }

    /**
     * Set done value.
     */
    public void setDone() {
        this.done = true;
    }
}