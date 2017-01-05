package com.company.trees;

import com.company.Node;

import java.util.ArrayList;

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

    public boolean find(T value) {
        return find(root, value);
    }

    private boolean find(Node<T> currentNode, T value) {
        while (currentNode != null) {
            if (value.compareTo(currentNode.data) < 0)
                currentNode = currentNode.left;
            else if (value.compareTo(currentNode.data) > 0)
                currentNode = currentNode.right;
            else
                return true;
        }
        return false;
    }

    public void remove(T value) throws Exception {
        remove(root, value);
    }

    private Node<T> remove(Node<T> currentNode, T value) throws Exception {
        if (currentNode == null) {
            throw new Exception("Element not found");
        }
        if (value.compareTo(currentNode.data) < 0) {
            currentNode.left = remove(currentNode.left, value);
        } else if (value.compareTo(currentNode.data) > 0) {
            currentNode.right = remove(currentNode.right, value);
        } else if (currentNode.left != null && currentNode.right != null) {
            currentNode.data = (T) findMin(currentNode.right).data;
            currentNode.right = removeMin(currentNode.right);
        } else {
            currentNode = (currentNode.left != null) ? currentNode.left : currentNode.right;
        }
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

    public T findMin() {
        return findMin(root).data;
    }

    private Node<T> findMin(Node<T> currentNode) {
        if (currentNode != null) {
            while (currentNode.left != null) {
                currentNode = currentNode.left;
            }
        }
        return currentNode;
    }

    public T findMax() {
        return findMax(root).data;
    }

    public Node<T> findMax(Node<T> currentNode) {
        if (currentNode != null) {
            while (currentNode.right != null) {
                currentNode = currentNode.right;
            }
        }
        return currentNode;
    }

    private ArrayList<T> treeArray = new ArrayList<>();

    public ArrayList<T> toArray(){
        return toArray(root);
    }

    private ArrayList<T> toArray(Node<T> currentNode) {
        if (currentNode != null) {
            toArray(currentNode.left);
            toArray(currentNode.right);
            treeArray.add(currentNode.data);
        }
        return treeArray;
    }
}
