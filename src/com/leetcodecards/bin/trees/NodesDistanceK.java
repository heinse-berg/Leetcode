package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class NodesDistanceK {


    public void populateParent(TreeNode root, TreeNode par, HashMap<TreeNode, TreeNode> ancestors) {
        if(root == null)
            return;

        ancestors.put(root, par);
        populateParent(root.left, root, ancestors);
        populateParent(root.right, root, ancestors);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;

        HashMap<TreeNode, TreeNode> ancestors = new HashMap<>();
        populateParent(root, null, ancestors);

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        HashSet<Integer> visited = new HashSet<>();
        q.addLast(target);

        while (!q.isEmpty() && k > 0) {
            int currSize = q.size();

            for(int i = 0; i < currSize; i++) {
                TreeNode curr = q.removeFirst();
                visited.add(curr.val);

                if(ancestors.containsKey(curr) && ancestors.get(curr) != null && !visited.contains(ancestors.get(curr).val))
                    q.addLast(ancestors.get(curr));

                if(curr.left != null && !visited.contains(curr.left.val))
                    q.addLast(curr.left);
                if(curr.right != null && !visited.contains(curr.right.val))
                    q.addLast(curr.right);

            }

            k--;
        }

        for(TreeNode t : q)
            res.addLast(t.val);

        return res;
    }

    public static void main(String[] args) {
        NodesDistanceK abc = new NodesDistanceK();
        System.out.println();
    }
}
