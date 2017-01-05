package com.company;

import com.company.trees.BinarySearchTree;
import com.company.trees.BinaryTree;
import com.company.trees.AvlTree;

public class Main {

    public static void main(String[] args) throws Exception {
        int countLeaf = 10;
        BinaryTree<Integer> bt = new BinaryTree<>();
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        AvlTree<Integer> avlt = new AvlTree<>();
        for (int i = 0; i < countLeaf; i++) {
            bt.insert(i);
            bst.insert(i);
            avlt.insert(i);
        }
        final int RM_VALUE = 5;
        bt.remove(RM_VALUE);
        bst.remove(RM_VALUE);
        avlt.remove(RM_VALUE);

        System.out.print("I. TEST MIN/MAX\n");
        System.out.print("Min and max value in binary tree: " + bt.findMin() + ", " + bt.findMax() + "\n");
        System.out.print("Max and max value in binary search tree: " + bst.findMin() + ", " + bst.findMax() + "\n");
        System.out.print("Max and max value in AVL tree: " + avlt.findMin() + ", " + avlt.findMax() + "\n");
        System.out.print("I. TEST REMOVING\n");
        System.out.print("Find removed value in binary tree: " + bt.find(RM_VALUE) + "\n");
        System.out.print("Find removed value in binary search tree: " + bst.find(RM_VALUE) + "\n");
        System.out.print("Find removed value in AVL tree: " + avlt.find(RM_VALUE));
    }
}