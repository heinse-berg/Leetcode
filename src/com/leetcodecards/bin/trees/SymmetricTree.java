package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

public class SymmetricTree {

    public boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;

        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return helper(root.left, root.right);
    }

    public static void main(String[] args) {
        SymmetricTree abc = new SymmetricTree();
        System.out.println(abc.isSymmetric(TreeNode.getSymmetric()));
    }
}
