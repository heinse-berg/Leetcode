package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class Vertical {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, PriorityQueue<int[]>> res = new TreeMap<>();
        int row = 0;
        Comparator<int[]> comparator = ((a, b) -> {
            if(a[0] == b[0]) {
                if(a[1] == b[1]) {
                    return a[2] - b[2];
                }
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        if(root == null)
            return new ArrayList<>();

        ArrayDeque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.addLast(new Pair<>(root, 0));

        while(!q.isEmpty()) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                Pair<TreeNode, Integer> pair = q.removeFirst();
                TreeNode curr = pair.getKey();
                int col = pair.getValue();

                if(!res.containsKey(col))
                    res.put(col, new PriorityQueue<>(comparator));
                res.get(col).add(new int[] { row, col, curr.val });

                if(curr.left != null)
                    q.addLast(new Pair<>(curr.left, col-1));
                if(curr.right != null)
                    q.addLast(new Pair<>(curr.right, col+1));
            }
            row++;
        }

        ArrayList<List<Integer>> list = new ArrayList<>();

        for(PriorityQueue<int[]> pq : res.values()) {
            ArrayList<Integer> l = new ArrayList<>();
            while(!pq.isEmpty()) {
                l.add(pq.poll()[2]);
            }
            list.add(l);
        }

        return list;

    }

    public static void main(String[] args) {
        Vertical abc = new Vertical();
        System.out.println();
    }
}
