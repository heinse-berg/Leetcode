package com.leetcodecards.bin.trees.construct.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PreorderInorder {
    int n;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int left, int right, int[] inorder, int[] preorder, AtomicInteger preorderIndex) {

        if(left > right)
            return null;

        int val = preorder[preorderIndex.getAndIncrement()];
        TreeNode root = new TreeNode(val);
        int index = map.get(val);

        root.left = buildTree(left, index-1, inorder, preorder, preorderIndex);
        root.right = buildTree(index+1, right, inorder, preorder, preorderIndex);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] preorder) {

        n = inorder.length;

        for(int i = 0; i < n; i++)
            map.put(inorder[i], i);

        return buildTree(0, n-1, inorder, preorder, new AtomicInteger(0));
    }

    public static void main(String[] args) {
        PreorderInorder abc = new PreorderInorder();
        System.out.println(abc.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
    }
}
