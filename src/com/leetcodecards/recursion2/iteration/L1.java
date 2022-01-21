package com.leetcodecards.recursion2.iteration;

import com.leetcodecards.recursion1.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class L1 {
    LinkedList<Pair<Integer, TreeNode>> map = new LinkedList<>();
    LinkedList<List<Integer>> res = new LinkedList<>();

    public void storeLevelMap(TreeNode root, int depth) {
        if(root == null)
            return;

        map.add(new Pair<>(depth, root));

        while(map.size() > 0) {
            Pair<Integer, TreeNode> pair = map.getFirst();
            int currDepth = pair.getKey();
            TreeNode curr = pair.getValue();

            if (res.size() <= currDepth) {
                LinkedList<Integer> l = new LinkedList<>();
                l.add(curr.val);
                res.add(currDepth, l);
            }
            else res.get(currDepth).add(curr.val);

            currDepth++;
            if(curr.left != null) map.add(new Pair<>(currDepth, curr.left));
            if(curr.right != null) map.add(new Pair<>(currDepth, curr.right));
            map.removeFirst();
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        storeLevelMap(root, 0);
        return res;
    }

    public static void main(String[] args) {
        L1 abc = new L1();
        abc.levelOrder(TreeNode.getRoot());
        System.out.println(abc.res);
    }
}
