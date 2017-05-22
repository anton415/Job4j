package ru.aserdyuchenko.generic.task_5_2_2;

/**
 * @author anton.
 */
public class RoleStore implements Store {
    /**
     * @param array - role store.
     */
    private SimpleArray<Role> array = new SimpleArray(10);

    @Override
    public void add(Base value) {
        this.array.add(value);
    }

    @Override
    public void update(int position, Base value) {
        this.array.update(position, value);
    }

    @Override
    public void delete(int position) {
        this.array.delete(position);
    }

    /**
     * Method get role.
     * @param position - position in array.
     * @return role.
     */
    public Role get(int position) {
        return this.array.get(position);
    }
}
