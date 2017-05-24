package ru.aserdyuchenko.list.task_5_3_1;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author anton.
 */
public class MyOwnListTest {
    /**
     * @param myOwnList - list.
     */
    private MyOwnList<Integer> myOwnList = new MyOwnList();

    /**
     * Add new value.
     */
    @Test
    public void whenAddNewValue() {
        myOwnList.add(123);
        Integer result = myOwnList.get(0);
        assertThat(result, is(123));
    }

    /**
     * Add three new values.
     */
    @Test
    public void whenAddThreeNewValues() {
        myOwnList.add(101);
        myOwnList.add(102);
        myOwnList.add(103);
        Integer result = myOwnList.get(2);
        assertThat(result, is(103));
    }
}