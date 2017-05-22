package ru.aserdyuchenko.generic.task_5_2_2;

/**
 * @author anton.
 */
public class User extends Base {
    /**
     * @param id - user id.
     */
    private String id;

    /**
     * Constructor.
     */
    public User() {
        this.id = "000";
    }
    /**
     * Constructor.
     * @param id - user id.
     */
    public User(String id) {
        this.id = id;
    }

    /**
     * Method get id.
     * @return id.
     */
    public String getId() {
        return this.id;
    }
}
