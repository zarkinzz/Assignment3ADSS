package models;

import java.util.Iterator;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {

    private Node root;
    private int size = 0;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // Public Entry class for iteration
    public static class Entry<K, V> {
        private final K key;
        private final V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }

    // 1. put() - Iterative
    public void put(K key, V val) {
        Node newNode = new Node(key, val);
        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Node current = root;
        Node parent = null;
        while (current != null) {
            parent = current;
            int cmp = key.compareTo(current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else {
                current.val = val;
                return;
            }
        }

        int cmp = key.compareTo(parent.key);
        if (cmp < 0)
            parent.left = newNode;
        else
            parent.right = newNode;

        size++;
    }

    // 2. get() - Iterative
    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp < 0)
                current = current.left;
            else if (cmp > 0)
                current = current.right;
            else
                return current.val;
        }
        return null;
    }

    // 3. delete() - Iterative
    public void delete(K key) {
        root = deleteIterative(root, key);
    }

    private Node deleteIterative(Node root, K key) {
        Node parent = null;
        Node current = root;

        while (current != null && !current.key.equals(key)) {
            parent = current;
            int cmp = key.compareTo(current.key);
            current = cmp < 0 ? current.left : current.right;
        }

        if (current == null) return root;

        // Case 1: Node has no children
        if (current.left == null && current.right == null) {
            if (current == root) return null;
            if (parent.left == current) parent.left = null;
            else parent.right = null;
        }

        // Case 2: Node has one child
        else if (current.left == null || current.right == null) {
            Node child = (current.left != null) ? current.left : current.right;
            if (current == root) return child;
            if (parent.left == current) parent.left = child;
            else parent.right = child;
        }

        // Case 3: Node has two children
        else {
            Node successorParent = current;
            Node successor = current.right;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

            current.key = successor.key;
            current.val = successor.val;

            if (successorParent.left == successor)
                successorParent.left = successor.right;
            else
                successorParent.right = successor.right;
        }

        size--;
        return root;
    }

    // 4. size()
    public int size() {
        return size;
    }

    // 5. iterator() - in-order traversal
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<>() {
            private final Stack<Node> stack = new Stack<>();
            private Node current = root;

            {
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }
            }

            @Override
            public boolean hasNext() {
                return !stack.isEmpty();
            }

            @Override
            public Entry<K, V> next() {
                Node node = stack.pop();
                Entry<K, V> entry = new Entry<>(node.key, node.val);
                Node right = node.right;
                while (right != null) {
                    stack.push(right);
                    right = right.left;
                }
                return entry;
            }
        };
    }
}

