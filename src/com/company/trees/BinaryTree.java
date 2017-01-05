package com.company.trees;

import com.company.Node;

public class BinaryTree<T extends Comparable> {

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> currentNode, T value) {
        if (currentNode == null) {
            currentNode = new Node<>(value);
        } else if (currentNode.left == null) {
            currentNode.left = insert(currentNode.left, value);
        } else {
            currentNode.right = insert(currentNode.right, value);
        }
        return currentNode;
    }

    public boolean find(T value) {
        return find(root, value);
    }

    private boolean find(Node<T> currentNode, T value) {
        while (currentNode != null) {
            if (value.compareTo(currentNode.data) > 0)
                currentNode = currentNode.left;
            else if (value.compareTo(currentNode.data) < 0)
                currentNode = currentNode.right;
            else
                return true;
        }
        return false;
    }

    public void remove(T value) throws Exception {
        remove(root, value);
    }

    public Node<T> remove(Node<T> currentNode, T value) throws Exception {
        if (currentNode == null) {
            throw new Exception("Element not found");
        }
        if (value.equals(currentNode.data)) {
            if (currentNode.left != null) {
                currentNode.left = remove(currentNode.left, value);
            } else if (currentNode.right != null) {
                currentNode.right = remove(currentNode.right, value);
            } else {
                currentNode = null;
            }
        }
        return currentNode;
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
        return findMax(root, root.data);
    }

    private T findMax(Node<T> currentNode, T maxValue) {
        maxValue = maxValue.compareTo(currentNode.data) < 0 ? currentNode.data : maxValue;
        if (currentNode.left != null) {
            findMax(currentNode.left, maxValue);
        } else if (currentNode.right != null) {
            findMax(currentNode.right, maxValue);
        }
        return maxValue;
    }
}