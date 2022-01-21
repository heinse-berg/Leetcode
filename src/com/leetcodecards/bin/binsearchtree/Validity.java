package com.leetcodecards.bin.binsearchtree;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

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
