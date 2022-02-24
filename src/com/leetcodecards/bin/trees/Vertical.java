package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class Vertical {

    TreeMap<Integer, LinkedList<int[]>> map = new TreeMap<>();

    public void helper(TreeNode c, int col, int row) {

        if(!map.containsKey(col))
            map.put(col, new LinkedList<>());
        map.get(col).add(new int[] {row, col, c.val});

        if(c.left != null)
            helper(c.left, col-1, row+1);

        if(c.right != null)
            helper(c.right, col+1, row+1);

    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();

        if(root == null)
            return ans;
        helper(root, 0, 0);

        for(LinkedList<int[]> list : map.values()) {
            ans.add(new LinkedList<>());
            list.sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0]-b[0] );
            List<Integer> l = ans.get(ans.size()-1);
            for(int[] t : list)
                l.add(t[2]);
        }

        return ans;

    }

    public static void main(String[] args) {
        Vertical abc = new Vertical();
        System.out.println();
    }
}
