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
        //bt.remove(0);
        bst.remove(9);
        avlt.remove(9);
        //System.out.print(bt.findMin() + "\n");
        System.out.print(bst.findMax() + "\n");
        System.out.print(avlt.findMax());
    }
}
