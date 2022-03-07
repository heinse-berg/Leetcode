package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

public class SubTree {

    public boolean isSame(TreeNode root, TreeNode subRoot) {

        if(root == null && subRoot == null)
            return true;

        if(root == null || subRoot == null)
            return false;

        return root.val == subRoot.val && isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if(root == null)
            return false;

        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
