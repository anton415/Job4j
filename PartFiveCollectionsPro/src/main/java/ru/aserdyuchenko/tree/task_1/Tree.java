package ru.aserdyuchenko.tree.task_1;

import java.util.*;

/**
 * @author anton.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * @param counter - counter.
     */
    private int counter = 0;
    Node<E> node;

    public Tree(Comparator<E> comparator) {
    }

    @Override
    public boolean add(E parent, E child) {
        try {
            node = new Node(parent);
            node.children.add(new Node(child));
            counter++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }



    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < counter;
            }

            @Override
            public E next() {
                currentIndex++;
                return node.getParent();
            }
        };


    }

    class Node<E> {
        List<Node<E>> children;
        E parent;

        /**
         * Constructor.
         * @param e - new value.
         */
        Node(E e) {
            this.children = new LinkedList<>();
            this.parent = e;
        }

        /**
         * Get next.
         * @return - next.
         */
        public List<Node<E>> getChildren()  {
            return this.children;
        }

        /**
         * Get value.
         * @return - value.
         */
        public E getParent() {
            return parent;
        }

    }
}