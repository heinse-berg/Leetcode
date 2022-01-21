package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

public class PathSum {

    public boolean helper(TreeNode root, int targetSum, int currSum) {
        if(root == null) return false;
        currSum += root.val;
        if(currSum == targetSum && (root.left == null && root.right == null)) return true;
        return helper(root.left, targetSum, currSum) || helper(root.right, targetSum, currSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;

        return helper(root, targetSum, 0);
    }

    public static void main(String[] args) {
        PathSum abc = new PathSum();
        System.out.println(abc.hasPathSum(TreeNode.getPathSumNodes(), 22));
    }
}
