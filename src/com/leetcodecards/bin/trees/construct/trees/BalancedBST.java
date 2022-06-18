package com.leetcodecards.bin.trees.construct.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

import static com.leetcodecards.recursion1.TreeNode.getSample;

public class BalancedBST {

    ArrayList<TreeNode> nodes = new ArrayList<>();

    public void inorder(TreeNode root) {
        if(root == null)
            return;
        inorder(root.left);
        nodes.add(root);
        inorder(root.right);
    }

    public TreeNode build(int low, int high) {
        if(low > high)
            return null;

        int mid = low + (high-low)/2;
        TreeNode root = nodes.get(mid);

        root.left = build(low, mid-1);
        root.right = build(mid+1, high);

        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);

        return build(0, nodes.size()-1);
    }

    public static void main(String[] args) {
        BalancedBST bst = new BalancedBST();
        System.out.println(bst.balanceBST(getSample()));
    }
}
