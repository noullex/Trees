package com.company.trees;

import com.company.Node;
import com.sun.corba.se.impl.corba.TCUtility;

import java.util.ArrayList;

public class AvlTree<T extends Comparable> {

    private Node<T> root;

    public AvlTree() {
        root = null;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> currentNode, T value) {
        if (currentNode == null)
            currentNode = new Node<T>(value);
        else if (value.compareTo(currentNode.data) < 0) {
            currentNode.left = insert(currentNode.left, value);
            if (height(currentNode.left) - height(currentNode.right) == 2)
                if (value.compareTo(currentNode.left.data) < 0)
                    currentNode = rotateWithLeftChild(currentNode);
                else
                    currentNode = doubleWithLeftChild(currentNode);
        } else if (value.compareTo(currentNode.data) > 0) {
            currentNode.right = insert(currentNode.right, value);
            if (height(currentNode.right) - height(currentNode.left) == 2)
                if (value.compareTo(currentNode.right.data) > 0)
                    currentNode = rotateWithRightChild(currentNode);
                else
                    currentNode = doubleWithRightChild(currentNode);
        }
        currentNode.height = max(height(currentNode.left), height(currentNode.right)) + 1;
        return currentNode;
    }

    public boolean find(T value) {
        return find(root, value);
    }

    private boolean find(Node<T> currentNode, T value) {
        while (currentNode != null)
            if (value.compareTo(currentNode.data) < 0)
                currentNode = currentNode.left;
            else if (value.compareTo(currentNode.data) > 0)
                currentNode = currentNode.right;
            else
                return true;
        return false;
    }

    public void remove(T value) {
        remove(root, value);
    }

    private Node<T> remove(Node<T> currentNode, T value) {
        if (currentNode == null) {
            return null;
        }
        if (value.compareTo(currentNode.data) < 0) {
            if (currentNode.left == null) {
                return null;
            } else {
                currentNode.left = remove(currentNode.left, value);
                currentNode.height = max(height(currentNode.left), height(currentNode.right)) + 1;
                if (height(currentNode.right) - height(currentNode.left) == 2) {
                    if (currentNode.right.left.height > currentNode.right.right.height) {
                        return doubleWithRightChild(currentNode);
                    } else {
                        return rotateWithRightChild(currentNode);
                    }
                }
            }
        } else {
            if (value.compareTo(currentNode.data) > 0) {
                if (currentNode.right == null) {
                    return null;
                } else {
                    currentNode.right = remove(currentNode.right, value);
                    currentNode.height = max(height(currentNode.left), height(currentNode.right)) + 1;
                    if (height(currentNode.left) - height(currentNode.right) == 2) {
                        if (currentNode.left.left.height > currentNode.left.right.height) {
                            return doubleWithLeftChild(currentNode);
                        } else {
                            return rotateWithLeftChild(currentNode);
                        }
                    }
                }
            } else {
                if ((currentNode.right != null) && (currentNode.left != null)) {
                    currentNode.data = (T) findMax(currentNode.left).data;
                    currentNode.left = remove(currentNode.left, currentNode.data);
                } else {
                    if (currentNode.left != null) {
                        return currentNode.left;
                    } else {
                        return currentNode.right;
                    }
                }
            }
        }
        return currentNode;
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

    private Node<T> findMax(Node<T> currentNode) {
        if (currentNode != null) {
            while (currentNode.right != null) {
                currentNode = currentNode.right;
            }
        }
        return currentNode;
    }

    private ArrayList<T> treeArray = new ArrayList<>();

    public ArrayList<T> toArray() {
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

    private int height(Node<T> node) {
        return node == null ? -1 : node.height;
    }

    private int max(int lhs, int rhs) {
        return lhs > rhs ? lhs : rhs;
    }

    private Node<T> rotateWithLeftChild(Node<T> k2) {
        Node<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = max(height(k2.left), height(k2.right)) + 1;
        k1.height = max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private Node<T> rotateWithRightChild(Node<T> k1) {
        Node<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = max(height(k1.left), height(k1.right)) + 1;
        k2.height = max(height(k2.right), k1.height) + 1;
        return k2;
    }

    private Node<T> doubleWithLeftChild(Node<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private Node<T> doubleWithRightChild(Node<T> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }
}