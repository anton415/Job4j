package ru.aserdyuchenko.list.task_5_3_4;

import java.util.LinkedList;
import java.util.List;

/**
 * @author anton.
 * @param <T> - T.
 */
public class Node<T> {
    /**
     * @param value - value.
     */
    private T value;
    /**
     * @param next - next.
     */
    private Node<T> next;

    /**
     * Constructor.
     * @param t - new value.
     */
    Node(T t) {
        this.next = null;
        this.value = t;
    }

    /**
     * Get next.
     * @return - next.
     */
    public Node getNext()  {
        return this.next;
    }

    /**
     * Set next.
     * @param nextValue - next value.
     */
    public void setNext(Node<T> nextValue) {
        this.next = nextValue;
    }

    /**
     * Has cycle.
     * @param first - first node.
     * @return true or false.
     */
    boolean hasCycle(Node first) {
        Node newNode = first.getNext();
        while (newNode != null) {
            if (first.equals(newNode)) {
                return true;
            } else {
                newNode = newNode.getNext();
            }
        }
        return false;
    }
}