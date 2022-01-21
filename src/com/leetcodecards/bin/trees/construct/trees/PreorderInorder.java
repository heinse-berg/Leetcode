package com.leetcodecards.bin.trees.construct.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class PreorderInorder {
    HashMap<Integer, Integer> map = new HashMap<>();
    int preIndex;
    int[] inorder, preorder;

    public TreeNode build(int leftIndex, int rightIndex) {
        if(leftIndex > rightIndex)
            return null;

        int rootElement = preorder[preIndex];
        TreeNode root = new TreeNode(rootElement);
        int index = map.get(rootElement);
        preIndex++;

        root.left = build(leftIndex, index-1);
        root.right = build(index+1, rightIndex);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder == null) return null;
        if(inorder.length == 1) return new TreeNode(inorder[0]);

        int i = 0, len = inorder.length;
        this.inorder = inorder;
        this.preorder = preorder;

        for(int num : inorder)
            map.put(num, i++);

        preIndex = 0;
        return build(0, len-1);
    }

    public static void main(String[] args) {
        PreorderInorder abc = new PreorderInorder();
        System.out.println(abc.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7}));
    }
}
