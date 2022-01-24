package com.leetcodecards.bin.binsearchtree;

import com.leetcodecards.recursion1.TreeNode;

public class Utility {

    public static TreeNode getBasic() {
        TreeNode node  = new TreeNode(20);
        node.left  = new TreeNode(10);
        node.left.left  = new TreeNode(5);
        node.left.right  = new TreeNode(14);
        node.left.right.left  = new TreeNode(11);
        node.left.left.left = new TreeNode(4);
        node.left.left.right  = new TreeNode(6);
        node.left.left.right.right  = new TreeNode(9);

        node.right  = new TreeNode(30);
        node.right.left  = new TreeNode(25);
        node.right.right  = new TreeNode(40);

        return node;
    }

    public static void main(String[] args) {
        Utility abc = new Utility();
        System.out.println();
    }
}
