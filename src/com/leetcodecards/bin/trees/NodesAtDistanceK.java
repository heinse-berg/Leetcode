package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class NodesAtDistanceK {

    public void populateParents(TreeNode root, TreeNode target, TreeNode par, HashMap<TreeNode, TreeNode> ancestors) {
        ancestors.put(root, par);

        if(root == null || root == target)
            return;

        populateParents(root.left, target, root, ancestors);
        populateParents(root.right, target, root, ancestors);
    }

    public List<Integer> getNodes(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> ancestors = new HashMap<>();
        LinkedList<Integer> res = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        populateParents(root, target, null, ancestors);

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(target);

        while(!q.isEmpty() && k > 0) {
            int currSize = q.size();

            for(int i = 0; i < currSize; i++) {
                TreeNode curr = q.pollFirst();
                visited.add(curr.val);

                if(ancestors.get(curr) != null && !visited.contains(ancestors.get(curr).val))
                    q.addLast(ancestors.get(curr));

                if(curr.left != null && !visited.contains(curr.left.val))
                    q.addLast(curr.left);

                if(curr.right != null && !visited.contains(curr.right.val))
                    q.addLast(curr.right);
            }

            k--;
        }

        q.forEach(a -> res.add(a.val));

        return res;
    }

    public static void main(String[] args) {
        NodesAtDistanceK abc = new NodesAtDistanceK();
        TreeNode node = new TreeNode(3);

        node.left = new TreeNode(5);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        node.left.right.left.left = new TreeNode(10);
        node.left.right.left.right = new TreeNode(11);

        node.right = new TreeNode(1);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);

        System.out.println(abc.getNodes(node, node.left.right.left.left, 4));
    }
}
