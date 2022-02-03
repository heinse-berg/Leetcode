package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class Cousins {

    public Pair<Integer, TreeNode> depth(TreeNode root, int val, Integer depth, TreeNode par) {
        if(root == null)
            return null;
        if(root.val == val)
            return new Pair<>(depth, par);
        Pair<Integer, TreeNode> v = depth(root.left, val, depth + 1, root);
        return v == null ? depth(root.right, val, depth + 1, root) : v;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        Pair<Integer, TreeNode> xDepth = depth(root, x, 0, null);
        Pair<Integer, TreeNode> yDepth = depth(root, y, 0, null);
        return xDepth.getKey() == yDepth.getKey() && xDepth.getValue() != yDepth.getValue();
    }

    public static void main(String[] args) {
        Cousins abc = new Cousins();
        TreeNode n = new TreeNode(1);
        n.left = new TreeNode(2);
        n.left.right = new TreeNode(4);

        n.right = new TreeNode(3);
        n.right.right = new TreeNode(5);
        System.out.println(abc.isCousins(n, 4, 5));
    }
}
