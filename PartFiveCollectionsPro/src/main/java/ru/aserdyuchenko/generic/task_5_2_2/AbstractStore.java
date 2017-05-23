package ru.aserdyuchenko.generic.task_5_2_2;

/**
 * @author anton.
 */

/**
 * Abstract store.
 * @param <T> - T.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    /**
     * @param array - user store.
     */
    private SimpleArray<Base> array = new SimpleArray(10);

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
    public Base get(int position) {
        return this.array.get(position);
    }
}
