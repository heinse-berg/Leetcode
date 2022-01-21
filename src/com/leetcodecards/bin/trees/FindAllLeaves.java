package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class FindAllLeaves {
    List<String> treePaths = new LinkedList<>();

    public void getLeavesHelper(TreeNode node, StringBuilder s) {
        if(node == null) return;
        if(node.left == null && node.right == null) {
            treePaths.add(s.append(node.val).toString());
            return;
        }
        s.append(node.val).append("->");
        getLeavesHelper(node.left, s);
        s.delete(s.lastIndexOf("->")+2, s.length());
        getLeavesHelper(node.right, s);
        s.delete(s.lastIndexOf("->"), s.length());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        getLeavesHelper(root, new StringBuilder());
        return treePaths;
    }

    public static void main(String[] args) {
        FindAllLeaves abc = new FindAllLeaves();
        abc.binaryTreePaths(TreeNode.getRoot());
        System.out.println(abc.treePaths);
    }
}
