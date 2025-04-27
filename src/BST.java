import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BST<K extends Comparable<K>, V> implements Iterable<BST<K, V>.KeyValuePair> {
    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public class KeyValuePair {
        private K key;
        private V value;

        public KeyValuePair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value; // update if key exists
        }
        return node;
    }

    public V get(K key) {
        Node current = root;
        while (current != null) {
            int cmp = key.compareTo(current.key);
            if (cmp == 0) return current.value;
            else if (cmp < 0) current = current.left;
            else current = current.right;
        }
        return null;
    }

    @Override
    public Iterator<KeyValuePair> iterator() {
        return new BSTIterator();
    }

    private class BSTIterator implements Iterator<KeyValuePair> {
        private Stack<Node> stack = new Stack<>();

        public BSTIterator() {
            pushLeft(root);
        }

        private void pushLeft(Node node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public KeyValuePair next() {
            if (!hasNext()) throw new NoSuchElementException();
            Node node = stack.pop();
            pushLeft(node.right);
            return new KeyValuePair(node.key, node.value);
        }
    }
}