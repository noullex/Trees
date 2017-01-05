package com.company;

public class Node<T extends Comparable> {
    public T data;
    public int height;
    public Node left, right, parent;

    public Node(T data) {
        this.data = data;
        height = 0;
    }
}
