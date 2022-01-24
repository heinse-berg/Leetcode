package com.leetcodecards.bin.binsearchtree;

import com.leetcodecards.recursion1.TreeNode;

public class KthSmallestBST {
    int ans = 0;
    int k;

    public void inorder(TreeNode node, int count) {
        if(node == null)
            return;
        inorder(node.left, count);
        count++;
        if(count == k) {
            ans = node.val;
        }
        inorder(node.right, count);
    }

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root, 1);
        return ans;
    }

    public static void main(String[] args) {
        KthSmallestBST abc = new KthSmallestBST();
        TreeNode node = new TreeNode();
        node.left = new TreeNode(1);
        node.left.right = new TreeNode(2);
        node.right = new TreeNode(4);
        System.out.println(abc.kthSmallest(node, 1));
    }
}
