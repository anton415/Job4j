package ru.aserdyuchenko.tree.task_1;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * @author anton.
 */
public class TreeTest {
    private Tree<String> tree = new Tree<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    });

    @Test
    public void whenAddParentAndHisChild() {
        boolean result = tree.add("Иван", "Иван младший");
        assertTrue(result);
    }

    @Test
    public void whenCheckIsTreeBinary() {
        tree.add("Иван", "Иван младший");
        tree.add("Anton", "Anton младший");
        boolean result = tree.isBinary();
        assertTrue(result);
    }
}