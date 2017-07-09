package ru.aserdyuchenko.tree.task_2;

import ru.aserdyuchenko.tree.task_1.SimpleTree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author anton.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;

    public boolean isBinary() {
        boolean result = true;
        if (root != null) {
            if (!isBinary(root.left)) return false;
            if (countOfNodes(root) > 2) result = false;
            if (!isBinary(root.right)) return false;
        }
        return result;
    }

    private boolean isBinary(Node<E> node) {
        boolean result = true;
        if (node != null) {
            isBinary(node.left);
            if (countOfNodes(node) > 2) result = false;
            isBinary(node.right);
        }
        return result;
    }

    private int countOfNodes(Node<E> node) {
        int count = 0;
        if (node.left != null) count++;
        if (node.right != null) count++;
        return count;
    }

    @Override
    public boolean add(E parent, E child) {
        try {
            Node<E> node = new Node<E>(parent);
            if (root == null) {
                root = node;
                root.childen.add(new Node<E>(child));
                return true;
            } else insertRec(root, node, new Node<E>(child));
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    private void insertRec(Node<E> latestRoot, Node<E> parent, Node<E> child) {
        if (latestRoot.value.compareTo(parent.value) > 0) {
            if (latestRoot.left == null) {
                latestRoot.left = parent;
                latestRoot.left.childen.add(child);
            } else {
                insertRec(latestRoot.left, parent, child);
            }
        } else if (latestRoot.value.compareTo(parent.value) < 0) {
            if (latestRoot.right == null) {
                latestRoot.right = parent;
                latestRoot.right.childen.add(child);
            } else {
                insertRec(latestRoot.right, parent, child);
            }
        } else if (latestRoot.value.compareTo(parent.value) == 0) {
            latestRoot.childen.add(child);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Stack<Node<E>> stack = new Stack<>();
            private Node<E> current = root;

            @Override
            public boolean hasNext() {
                return (!stack.isEmpty() || current != null);
            }

            @Override
            public E next() {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }

                current = stack.pop();
                Node<E> node = current;
                current = current.right;

                return node.value;
            }
        };
    }

    class Node<E> {
        E value;
        Node<E> left, right;
        List<Node<E>> childen;

        /**
         * Constructor.
         * @param e - new value.
         */
        Node(E e) {
            this.value = e;
            left = right = null;
            childen = new LinkedList<>();
        }

        /**
         * Get value.
         * @return - parent.
         */
        public E getValue() {
            return this.value;
        }
    }
}