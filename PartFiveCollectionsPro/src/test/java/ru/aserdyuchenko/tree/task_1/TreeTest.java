package ru.aserdyuchenko.tree.task_1;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * @author anton.
 */
public class TreeTest {
    @Test
    public void whenAddParentAndHisChild() {
        Tree<String> tree = new Tree<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        boolean result = tree.add("Иван", "Иван младший");
        assertTrue(result);
    }
}