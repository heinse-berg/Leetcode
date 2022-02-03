package com.leetcodecards.recursion1;

import com.leetcodecards.bin.trees.Traversals;

import java.util.*;


public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode getRoot() {
        TreeNode node = new TreeNode(4);

        node.left = new TreeNode(20);
        node.left.left = new TreeNode(100);
        node.left.right = new TreeNode(300);
        node.left.left.left = new TreeNode(3000);
        node.left.left.right = new TreeNode(3500);
        node.left.left.right.left = new TreeNode(999);


        node.right = new TreeNode(50);
        node.right.right = new TreeNode(700);
        node.right.right.left = new TreeNode(6000);
        node.right.right.right = new TreeNode(8000);
        return node;
    }

    public static TreeNode getRoot1() {
        TreeNode node = new TreeNode(4);

        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);


        node.right = new TreeNode(5);
        node.right.right = new TreeNode(7);
        node.right.right.left = new TreeNode(6);
        node.right.right.right = new TreeNode(9);
        return node;
    }

    public static TreeNode getSample() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        return root;
    }

    public static TreeNode getSymmetric() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(6);

        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);


        return root;
    }

    public static TreeNode getPathSumNodes() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);


        return root;
    }

    @Override
    public String toString() {
        Traversals traversals = new Traversals();
        StringBuilder s =  new StringBuilder("PreOrder Traversal is \n") .append(traversals.preorderTraversal(this));
        s.append("\nPostorder Traversal is\n").append(traversals.postorderTraversal(this));
        s.append("\nInorder Traversal is\n").append(traversals.inorderIterative(this));
        return s.toString();
    }

    @Override
    public boolean equals(Object tree) {
        return checkTreeEquality(this, (TreeNode) tree);
    }

    public boolean checkTreeEquality(TreeNode tree1, TreeNode tree2) {
        if(tree1 == null && tree2 == null) return true;
        if(tree1 == null) return false;
        if(tree2 == null) return false;
        return tree1.val == tree2.val && checkTreeEquality(tree1.right, tree2.right) && checkTreeEquality(tree1.left, tree2.left);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(9);
        node.right = new TreeNode(20);
        node.right.left = new TreeNode(15);
        node.right.right = new TreeNode(7);
    }
}
