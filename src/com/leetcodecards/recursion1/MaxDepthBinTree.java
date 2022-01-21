package com.leetcodecards.recursion1;

import java.util.*;

public class MaxDepthBinTree {

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    public static void main(String[] args) {
        MaxDepthBinTree abc = new MaxDepthBinTree();
        System.out.println(abc.maxDepth(TreeNode.getRoot()));
    }
}
