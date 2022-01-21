package com.leetcodecards.hashing;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class DuplicateSubtrees {

    LinkedList<TreeNode> set = new LinkedList<>();
    LinkedList<TreeNode> list = new LinkedList<>();

    public TreeNode helper(TreeNode node) {
        if(node == null)
            return node;

        TreeNode left = helper(node.left);
        if(left != null) {
            if (!set.contains(left))
                set.add(left);
            else
                if(!list.contains(left))
                    list.add(left);
        }

        TreeNode right = helper(node.right);
        if(right != null) {
            if (!set.contains(right))
                set.add(right);
            else
                if(!list.contains(right))
                    list.add(right);
        }

        return node;
    }

    public void findDuplicateSubtrees(TreeNode root) {
        helper(root);
    }

    public static void main(String[] args) {
        DuplicateSubtrees abc = new DuplicateSubtrees();
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);
        r.left.left = new TreeNode(4);

        r.right = new TreeNode(3);
        r.right.left = new TreeNode(2);
        r.right.right = new TreeNode(4);
        r.right.left.left = new TreeNode(4);
        //System.out.println(abc.findDuplicateSubtrees(TreeNode.getRoot()));
        abc.findDuplicateSubtrees(r);
        System.out.println();
        System.out.println(r.equals(r));

    }
}
