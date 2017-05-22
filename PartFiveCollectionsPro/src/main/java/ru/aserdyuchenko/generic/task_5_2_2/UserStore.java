package ru.aserdyuchenko.generic.task_5_2_2;
/**
 * @author anton.
 */
public class UserStore implements Store {
    /**
     * @param array - user store.
     */
    private SimpleArray<User> array = new SimpleArray(10);

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
     * Method get user.
     * @param position - position in array.
     * @return user.
     */
    public User get(int position) {
        return this.array.get(position);
    }
}
