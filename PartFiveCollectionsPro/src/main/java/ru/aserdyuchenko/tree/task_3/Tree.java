package ru.aserdyuchenko.tree.task_3;

import ru.aserdyuchenko.tree.task_1.SimpleTree;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Anton Serdyuchenko. anton415@gmail.com
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * @param counter - counter.
     */
    private int counter = 0;
    Node<E> node;
    Node<E> head;
    Node<E> current;

    public Tree(Comparator<E> comparator) {
    }

    public boolean add(E e) {
        try {
            node = new Node<E>(e);
            if (head == null) {
                head = node;
            } else
            insertRec(head, node);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    private void insertRec(Node<E> latestRoot, Node<E> node) {
        if (latestRoot.parent.compareTo(node.parent) > 0) {
            if (latestRoot.left == null) {
                latestRoot.left = node;
            } else {
                insertRec(latestRoot.left, node);
            }
        } else {
            if (latestRoot.right == null) {
                latestRoot.right = node;
            } else {
                insertRec(latestRoot.right, node);
            }
        }
    }

    @Override
    public boolean add(E parent, E child) {
        try {
            if (head == null) {
                head = new Node<E>(parent);
            }

            Node<E> node = new Node<E>(parent);
            node.children.add(new Node<E>(child));
            current = head;

            if (current != null) {
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(node);
            }
            counter++;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Tree{" +
                "counter=" + counter +
                ", node=" + node +
                ", head=" + head +
                ", current=" + current +
                '}';
    }

    public boolean isBinary() {
        boolean result = true;
        Node<E> element = head;
        element = element.getNext();
        while (element != null) {
            List list = element.getChildren();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                Node<E> newElement = (Node<E>) iterator.next();
                if (!newElement.children.isEmpty()) {
                    result = false;
                    break;
                }
            }
            element = element.getNext();
        }

        return result;
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
                return current.getParent();
            }
        };


    }

    class Node<E> {
        List<Node<E>> children;
        E parent;
        Node<E> next;
        Node<E> left, right;

        /**
         * Constructor.
         * @param e - new value.
         */
        Node(E e) {
            this.children = new LinkedList<>();
            this.parent = e;
            this.next = null;
            left = right = null;
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
         * @return - parent.
         */
        public E getParent() {
            return parent;
        }

        public Node<E> getNext()  {
            return this.next;
        }

        /**
         * Set next.
         * @param nextValue - next value.
         */
        public void setNext(Node nextValue) {
            next = nextValue;
        }

    }
}
