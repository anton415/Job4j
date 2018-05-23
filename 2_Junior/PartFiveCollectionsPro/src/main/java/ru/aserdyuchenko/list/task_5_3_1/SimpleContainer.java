package ru.aserdyuchenko.list.task_5_3_1;

/**
 * Simple container.
 * @author Anton Serdyuchenko.
 * @param <E> - E.
 */
public interface SimpleContainer<E> extends Iterable<E> {
    /**
     * Add.
     * @param e - new value.
     */
    void add(E e);

    /**
     * Get.
     * @param index - index.
     * @return value.
     */
    E get(int index);
}
