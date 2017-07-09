package ru.aserdyuchenko.tree.task_2;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class TreeTest {
    private Tree<String> tree = new Tree<>();

    @Test
    public void whenCheckIsTreeBinary() {
        tree.add("A", "a");
        tree.add("B", "b");
        boolean result = tree.isBinary();
        assertTrue(result);
    }
}