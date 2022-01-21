package com.leetcodecards.bin.trees;
import com.leetcodecards.recursion1.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class Traversals {

    public List<Integer> preorderTraversal(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        if(curr == null)
            return res;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                res.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop();
            curr = curr.right;
        }

        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {

        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        if(root == null)
            return res;
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == pre) {
                res.add(root.val);
                stack.pop();
                pre = root;
                root = null;
            } else
                root = root.right;
        }

        return res;
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        ArrayDeque<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
        int depth = 0;

        if(root == null)
            return res;

        TreeNode curr = root;
        queue.push(new Pair<>(curr, depth));

        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.pop();
            curr = pair.getKey();
            depth =  pair.getValue();
            if(res.size() < depth+1) {
                List<Integer> temp = new ArrayList<>();
                temp.add(curr.val);
                res.add(temp);
            }
            else
                res.get(depth).add(curr.val);
            if(curr.left != null)
                queue.add(new Pair<>(curr.left, depth+1));
            if(curr.right != null)
                queue.add(new Pair<>(curr.right, depth+1));
        }
        return res;
    }

    public static void main(String[] args) {
        Traversals abc = new Traversals();
        System.out.println(abc.levelOrder(TreeNode.getRoot()));
    }
}
