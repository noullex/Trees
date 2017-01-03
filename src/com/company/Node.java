package com.company;

public class Node<T extends Comparable> {
    T data;
    Node left;
    Node right;

    public Node(T data) {
        this.data = data;
    }
}
