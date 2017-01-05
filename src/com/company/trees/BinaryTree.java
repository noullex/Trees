package com.company.trees;

import com.company.Node;

public class BinaryTree<T extends Comparable> {

    private Node<T> root;

    public BinaryTree() {
        root = null;
    }

    public void insert(T value) {
        root = insert(root, null, value);
    }

    private Node<T> insert(Node<T> currentNode, Node<T> parentNode, T value) {
        if (currentNode == null) {
            currentNode = new Node<>(value);
            currentNode.parent = parentNode;
        } else if (currentNode.left == null) {
            currentNode.left = insert(currentNode.left, currentNode, value);
        } else {
            currentNode.right = insert(currentNode.right, currentNode, value);
        }
        return currentNode;
    }

    public boolean find(T value) {
        return find(root, value, false, false);
    }

    private boolean find(Node<T> currentNode, T value, boolean fromLeft, boolean fromParent) {
        if (!value.equals(currentNode.data)) {
            if (fromParent&& currentNode.right== null) {
                return false;
            }
            if (currentNode.left != null && !fromLeft) {
                find(currentNode.left, value, true, false);
            } else if (currentNode.right != null) {
                find(currentNode.right, value, false, false);
            } else {
                find(currentNode.parent, value, true, true);
            }
        } else {
            return true;
        }
        return false;
    }

    public void remove(T value) throws Exception {
        remove(root, value, false);
    }

    public Node<T> remove(Node<T> currentNode, T value, boolean fromLeft) throws Exception {
        if (currentNode == null) {
            throw new Exception("Element not found");
        }
        if (currentNode.data.equals(value)) {
            if (currentNode.parent != null && currentNode.left != null && currentNode.right != null) {
                currentNode.parent.left = currentNode.right;
                currentNode.parent.left.left = currentNode.left;
            } else if (currentNode.parent != null && currentNode.right != null) {
                currentNode.parent.left = currentNode.right;
            } else if (currentNode.parent != null && currentNode.left != null) {
                currentNode.parent.left = currentNode.left;
            } else {
                currentNode = null;
            }
        } else {
            if (currentNode.left != null && !fromLeft) {
                currentNode = remove(currentNode.left, value, true);
            } else if (currentNode.right != null) {
                currentNode = remove(currentNode.right, value, false);
            } else {
                currentNode = remove(currentNode.parent, value, true);
            }
        }
        return currentNode;
    }

    public T findMin() {
        return findMin(root, root.data, false);
    }

    private T findMin(Node<T> currentNode, T minValue, boolean fromLeft) {
        minValue = minValue.compareTo(currentNode.data) > 0 ? currentNode.data : minValue;
        if (fromLeft && currentNode.right == null) {
            return minValue;
        }
        if (currentNode.left != null && !fromLeft) {
            findMin(currentNode.left, minValue, true);
        } else if (currentNode.right != null) {
            findMin(currentNode.right, minValue, false);
        } else {
            findMin(currentNode.parent, minValue, true);
        }
        return minValue;
    }

    public T findMax() {
        return findMax(root, root.data, false);
    }

    private T findMax(Node<T> currentNode, T maxValue, boolean fromLeft) {
        maxValue = maxValue.compareTo(currentNode.data) < 0 ? currentNode.data : maxValue;
        if (fromLeft && currentNode.right == null) {
            return maxValue;
        }
        if (currentNode.left != null && !fromLeft) {
            findMax(currentNode.left, maxValue, true);
        } else if (currentNode.right != null) {
            findMax(currentNode.right, maxValue, false);
        } else {
            findMax(currentNode.parent, maxValue, true);
        }
        return maxValue;
    }
}