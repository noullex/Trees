package com.company;

public class BinarySearchTree<T extends Comparable> {

    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T value) {
        root = insert(value, root);
    }

    private Node<T> insert(T value, Node<T> currentNode) {
        if (currentNode == null) {
            currentNode = new Node<>(value);
        } else if (value.compareTo(currentNode.data) < 0) {
            currentNode.left = insert(value, currentNode.left);
        } else if (value.compareTo(currentNode.data) > 0) {
            currentNode.right = insert(value, currentNode.right);
        }
        return currentNode;
    }

    public void remove(T value) throws Exception {
        root = remove(value, root);
    }

    protected Node<T> remove(T x, Node<T> currentNode) throws Exception {
        if (currentNode == null) {
            throw new Exception("Element not found");
        }
        if (x.compareTo(currentNode.data) < 0) {
            currentNode.left = remove(x, currentNode.left);
        } else if (x.compareTo(currentNode.data) > 0) {
            currentNode.right = remove(x, currentNode.right);
        } else if (currentNode.left != null && currentNode.right != null) {
            currentNode.data = (T) findMin(currentNode.right).data;
            currentNode.right = removeMin(currentNode.right);
        } else
            currentNode = (currentNode.left != null) ? currentNode.left : currentNode.right;
        return currentNode;
    }

    private Node<T> removeMin(Node<T> currentNode) {
        if (currentNode.left != null) {
            currentNode.left = removeMin(currentNode.left);
            return currentNode;
        } else {
            return currentNode.right;
        }
    }

    public Node<T> findMin() {
        return findMin(root);
    }

    protected Node<T> findMin(Node<T> currentNode) {
        if (currentNode != null)
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }
        return currentNode;
    }

    public Node<T> findMax() {
        return findMax(root);
    }

    private Node<T> findMax(Node<T> currentNode) {
        if (currentNode != null)
            while (currentNode.right != null) {
                currentNode = currentNode.right;
            }
        return currentNode;
    }

    public Node<T> find(T value) {
        return find(value, root);
    }

    private Node<T> find(T value, Node<T> currentNode) {
        while (currentNode != null) {
            if (value.compareTo(currentNode.data) < 0)
                currentNode = currentNode.left;
            else if (value.compareTo(currentNode.data) > 0)
                currentNode = currentNode.right;
            else
                return currentNode;
        }
        return null;
    }
}
