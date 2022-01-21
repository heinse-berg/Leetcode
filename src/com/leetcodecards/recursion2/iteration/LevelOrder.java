package com.leetcodecards.recursion2.iteration;

import com.leetcodecards.recursion1.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class LevelOrder {
    List<List<Integer>> res = new LinkedList<>();
    public LinkedList<Pair<Integer, Integer>> map = new LinkedList<>();

    public void storeLevelMap1(TreeNode root, int depth) {
        if(root == null)
            return;
        map.add(new Pair<>(depth, root.val));
        storeLevelMap(root.left, depth+1);
        storeLevelMap(root.right, depth+1);
    }

    public void storeLevelMap(TreeNode root, int depth) {
        if(root == null)
            return;
        map.add(new Pair<>(depth, root.val));
        storeLevelMap(root.left, depth+1);
        storeLevelMap(root.right, depth+1);
    }

    public void levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root == null)
            return;
        queue.add(root);

        while(queue.size() > 0) {
            TreeNode curr = queue.getFirst();
            System.out.print(curr.val + " ");
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
            queue.removeFirst();
        }
    }

    public static void main(String[] args) {
        LevelOrder abc = new LevelOrder();
        /*abc.levelOrder(TreeNode.getRoot());
        System.out.println("\n-----");
        abc.levelOrder(TreeNode.getRoot1());
        System.out.println();*/
        abc.storeLevelMap(TreeNode.getRoot(), 1);
        abc.map.sort(Comparator.comparing(Pair::getKey));
        System.out.println(abc.map);
    }
}
