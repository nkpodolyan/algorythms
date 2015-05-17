package com.positive.datastructures.tst;

/**
 * Created by mykola on 16.05.15.
 */
public class TSTSet<T> {

    private Node<T> root;

    private static class Node<T> {
        private T value;
        private char c;
        private Node<T> left;
        private Node<T> next;
        private Node<T> right;

        private Node(char c) {
            this.c = c;
        }

        private boolean isLeaf() {
            return left == null && right == null && next == null;
        }
    }

    public void put(String key, T value) {
        if (root == null) {
            root = new Node<>(key.charAt(0));
        }
        Node<T> current = null;
        for (int i = 0; i < key.length(); i++) {
            if (current == null) current = root;
            else {
                if (current.next == null) current.next = new Node<>(key.charAt(i));
                current = current.next;
            }
            char c = key.charAt(i);
            while (c != current.c) {
                Node<T> child = current.c > c ? current.left : current.right;
                if (child == null) {
                    child = new Node<>(c);
                    if (current.c > c) current.left = child;
                    else current.right = child;
                }
                current = child;
            }
        }
        current.value = value;
    }

    public T get(String key) {
        if (root == null) {
            return null;
        }
        Node<T> current = null;
        for (int i = 0; i < key.length(); i++) {
            if (current == null) current = root;
            else current = current.next;
            if (current == null) return null;
            char c = key.charAt(i);
            while (c != current.c) {
                current = current.c > c ? current.left : current.right;
                if (current == null) return null;
            }
        }
        return current.value;
    }

    public void remove(String key) {
        Node<T> parent = root;
        int cIndex = 0;
        Node<T> current = null;
        for (int i = 0; i < key.length(); i++) {
            if (current == null) current = root;
            else current = current.next;
            if (current == null) return;

            if (current.value != null || current.right != null || current.left != null) {
                parent = current;
                cIndex = i;
            }
            char c = key.charAt(i);
            while (c != current.c) {
                parent = current;
                cIndex = i;
                current = current.c > c ? current.left : current.right;
                if (current == null) return;
            }
        }
        if (current.isLeaf()) {
            if (parent != null) {
                char c = key.charAt(cIndex);
                if (parent.next.c == c) parent.next = null;
                else if (parent.c > c) parent.left = null;
                else parent.right = null;
            }
        } else {
            current.value = null;
        }

    }

}
