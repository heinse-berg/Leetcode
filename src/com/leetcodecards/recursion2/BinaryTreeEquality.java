package com.leetcodecards.recursion2;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class BinaryTreeEquality {

    public boolean areEqual(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 != null && root2 != null && root1.val != root2.val) return false;
        return (root1 != null && root2 != null) && areEqual(root1.left, root2.left) &&
                areEqual(root1.right, root2.right);
    }

    public static void main(String[] args) {
        BinaryTreeEquality abc = new BinaryTreeEquality();
        System.out.println(abc.areEqual(TreeNode.getRoot(), TreeNode.getRoot1()));
    }
}
