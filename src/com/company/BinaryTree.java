package com.company;

public class BinaryTree<T extends Comparable> {

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> currentNode, T value) {
        if (currentNode == null)
            root = new Node<>(value);
        else {
            if (currentNode.left == null)
                currentNode.left = insert(currentNode.left, value);
            else {
                currentNode.right = insert(currentNode.left, value);
            }
        }
        return currentNode;
    }

    public Node<T> find(T value) {
        return find(root, value);
    }

    private Node<T> find(Node<T> currentNode, T value) {
        if (value.equals(currentNode.data)) {
            return currentNode;
        } else if (currentNode.left != null) {
            find(currentNode.left, value);
        } else if (currentNode.right != null) {
            find(currentNode.right, value);
        }
        return null;
    }

    public void remove(T value) throws Exception {
        Node<T> currentNode = find(value);
        if (currentNode != null) {
            currentNode = (currentNode.left != null) ? currentNode.left : currentNode.right;
        } else {
            throw new Exception("Element not found");
        }
    }

    public T findMin() {
        return findMin(root, root.data);
    }

    private T findMin(Node<T> currentNode, T minValue) {
        minValue = minValue.compareTo(currentNode.data) > 0 ? currentNode.data : minValue;
        if (currentNode.left != null) {
            findMin(currentNode.left, minValue);
        } else if (currentNode.right != null) {
            findMin(currentNode.right, minValue);
        }
        return minValue;
    }

    public T findMax() {
        return findMin(root, root.data);
    }

    private T findMax(Node<T> currentNode, T maxValue) {
        maxValue = maxValue.compareTo(currentNode.data) < 0 ? currentNode.data : maxValue;
        if (currentNode.left != null) {
            findMin(currentNode.left, maxValue);
        } else if (currentNode.right != null) {
            findMin(currentNode.right, maxValue);
        }
        return maxValue;
    }
}