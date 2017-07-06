package ru.aserdyuchenko.tree.task_3;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
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
        tree.add("Anton");
        boolean result = tree.add("Иван");
        assertTrue(result);
    }

}