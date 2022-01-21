package com.leetcodecards.bin.trees.construct.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.HashMap;

public class PostorderInorder {
    HashMap<Integer, Integer> map = new HashMap<>();
    int postIndex;
    int[] inorder, postorder;

    public TreeNode build(int leftIndex, int rightIndex) {

        if(leftIndex > rightIndex)
            return null;

        int index = map.get(postorder[postIndex]);
        TreeNode root = new TreeNode(postorder[postIndex]);
        postIndex--;

        root.right = build(index+1, rightIndex);
        root.left = build(leftIndex, index-1);

        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null) return null;
        if(inorder.length == 1) return new TreeNode(inorder[0]);

        int i = 0, len = inorder.length;
        this.inorder = inorder;
        this.postorder = postorder;

        for(int num : inorder)
            map.put(num, i++);

        postIndex = len-1;
        return build(0, len-1);
    }

    public static void main(String[] args) {
        PostorderInorder abc = new PostorderInorder();
        TreeNode root = abc.buildTree(new int[] {9,3,15,20,7}, new int[] {9,3,15,20,7});
        System.out.println(root);
    }
}
