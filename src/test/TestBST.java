package test;

import models.BST;

public class TestBST {
    public static void main(String[] args) {
        BST<Integer, String> tree = new BST<>();
        tree.put(2, "two");
        tree.put(6, "six");
        tree.put(8, "eight");
        tree.put(1, "one");

        System.out.println("In-order traversal:");
        for (BST.Entry<Integer, String> entry : tree) {
            System.out.println("key is " + entry.getKey() + " and value is " + entry.getValue());
        }
    }
}

