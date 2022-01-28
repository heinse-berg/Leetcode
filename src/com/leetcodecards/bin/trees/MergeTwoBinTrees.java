package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class MergeTwoBinTrees {


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null)
            return null;
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        TreeNode node = new TreeNode();
        node.val = root1.val + root2.val;
        node.left = mergeTrees(root1.left, root2.left);
        node.right = mergeTrees(root1.right, root2.right);
        return node;
    }

    public static void main(String[] args) {
        MergeTwoBinTrees abc = new MergeTwoBinTrees();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(-1);
        root2.left = new TreeNode(-3);
        root2.left.right = new TreeNode(-4);
        root2.right = new TreeNode(-2);
        root2.right.right = new TreeNode(-7);
        TreeNode ans = abc.mergeTrees(root1, root2);
        System.out.println(abc.mergeTrees(root1, root2));
    }
}
