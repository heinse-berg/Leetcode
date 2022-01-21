package com.leetcodecards.recursion2.iteration;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class Inorder {

    public void inorderTraversal(TreeNode root) {
        if(root == null)
            return;
        inorderTraversal(root.left);
        System.out.print(root.val + " ");
        inorderTraversal(root.right);
    }

    public List<Integer> inorderIterative(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if(root == null)
            return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }

        return list;
    }

    public static void main(String[] args) {
        Inorder abc = new Inorder();
        TreeNode node = new TreeNode(1);
        node.right = new TreeNode(2);
        node.right.left = new TreeNode(3);
        System.out.println(abc.inorderIterative(TreeNode.getRoot()));
    }
}
