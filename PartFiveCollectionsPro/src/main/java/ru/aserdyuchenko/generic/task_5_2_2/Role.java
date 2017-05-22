package ru.aserdyuchenko.generic.task_5_2_2;

/**
 * @author anton.
 */
public class Role extends Base {
    /**
     * @param id - role id.
     */
    private String id;

    /**
     * Constructor.
     * @param id - role id.
     */
    public Role(String id) {
        this.id = id;
    }

    /**
     * Methor get id.
     * @return id.
     */
    public String getId() {
        return this.id;
    }
}
