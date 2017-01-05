package com.company;

public class Node<T extends Comparable> {
    public T data;
    public int height; //для сбалансированного дерева
    public Node left, right;

    public Node(T data) {
        this.data = data;
        height = 0;
    }
}
