package com.leetcodecards.recursion2;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class ValidateBinSearchTree {

    public boolean validate(TreeNode root, Integer low, Integer high) {
        if(root == null)
            return true;
        if((low != null && root.val <= low) || (high != null && root.val >= high))
            return false;
        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public static TreeNode getRoot() {
        TreeNode node = new TreeNode(4);

        node.left = new TreeNode(2);
        node.left.left = new TreeNode(1);
        node.left.right = new TreeNode(3);


        node.right = new TreeNode(5);
        node.right.right = new TreeNode(7);
        node.right.right.left = new TreeNode(6);
        node.right.right.right = new TreeNode(8);
        return node;
    }

    public static void main(String[] args) {
        ValidateBinSearchTree abc = new ValidateBinSearchTree();
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(6);
        node.right.left = new TreeNode(3);
        node.right.right = new TreeNode(7);
        System.out.println(abc.isValidBST(node));
    }
}
