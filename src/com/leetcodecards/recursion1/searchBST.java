package com.leetcodecards.recursion1;

public class searchBST {

    public TreeNode searchBSTIteratively(TreeNode root, int val) {
        while(root != null) {
            if(val == root.val)
                return root;
            else if(val < root.val)
                root = root.left;
            else
                root = root.right;
        }
        return null;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        if(root.val == val)
            return root;
        else if(val < root.val)
            return searchBST(root.left, val);
        return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        searchBST abc = new searchBST();

        System.out.println();
    }
}
