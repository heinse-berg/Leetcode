package com.leetcodecards.bin.binsearchtree;

import com.leetcodecards.recursion1.TreeNode;

public class Validity {
    TreeNode prev;

    public boolean isValidBST(TreeNode node) {
        if(node == null)
            return true;
        boolean left = isValidBST(node.left);
        if(prev != null && node.val < prev.val)
            return false;
        else
            prev = node;
        boolean right = isValidBST(node.right);
        return left && right;
    }

    public boolean helper(TreeNode node, TreeNode left, TreeNode right) {
        if(node == null)
            return true;
        if((left != null && node.val > left.val) || (right != null && node.val < right.val))
            return false;
        return helper(node.left, left, node) && helper(node.right, node, right);
    }

    public boolean isValid(TreeNode node) {
        return helper(node, null, null);
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode successor = null;

        while (root != null) {

            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    public static void main(String[] args) {
        Validity abc = new Validity();
        //System.out.println(abc.isValidBST(Utility.getBasic()));
        TreeNode t = new TreeNode(5);
        t.left = new TreeNode(4);
        t.right = new TreeNode(6);
        t.right.left = new TreeNode(3);
        t.right.right = new TreeNode(7);
        TreeNode t1 = new TreeNode(2);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(3);

        /*System.out.println(abc.isValidBST(t));*/
        //System.out.println(abc.inorderSuccessor(t1));
    }
}
