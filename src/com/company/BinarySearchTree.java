package com.company;

public class BinarySearchTree<T extends Comparable> {

    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> currentNode, T value) {
        if (currentNode == null) {
            currentNode = new Node<>(value);
        } else if (value.compareTo(currentNode.data) < 0) {
            currentNode.left = insert(currentNode.left, value);
        } else if (value.compareTo(currentNode.data) > 0) {
            currentNode.right = insert(currentNode.right, value);
        }
        return currentNode;
    }

    public Node<T> find(T value) {
        return find(root, value);
    }

    private Node<T> find(Node<T> currentNode, T value) {
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

    public void remove(T value) throws Exception {
        Node<T> currentNode = find(value);
        if (currentNode != null) {
            currentNode = (currentNode.left != null) ? currentNode.left : currentNode.right;
        } else {
            throw new Exception("Element not found");
        }
    }


    public T findMin() {
        Node<T> currentNode = root;
        if (currentNode != null) {
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }
        }
        return currentNode.data;
    }

    public T findMax() {
        Node<T> currentNode = root;
        if (currentNode != null) {
            while (currentNode.right != null) {
                currentNode = currentNode.right;
            }
        }
        return currentNode.data;
    }
}
