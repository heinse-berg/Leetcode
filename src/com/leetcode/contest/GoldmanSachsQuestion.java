package com.leetcode.contest;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class GoldmanSachsQuestion {

    public String burst(String arr, int burst) {
        int n = arr.length();

        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < n; i++) {
            int j = i;

            while(i < n-1 && arr.charAt(i) == arr.charAt(i+1))
                i++;

            if(i-j+1 < burst)
                ans.append(arr, j, i+1);
        }

        return ans.toString();
    }

    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashMap<TreeNode, TreeNode> lineage = new HashMap<>();

        for(int[] d : descriptions) {
            TreeNode child = map.containsKey(d[1]) ? map.get(d[1]) : new TreeNode(d[1]);
            TreeNode par = map.containsKey(d[0]) ? map.get(d[0]) : new TreeNode(d[0]);
            map.put(d[0], par);
            map.put(d[1], child);
            lineage.put(child, par);
            if(d[2] == 1)
                par.left = child;
            else
                par.right = child;
        }

        TreeNode entry = lineage.entrySet().iterator().next().getKey();

        while(lineage.containsKey(entry)) {
            entry = lineage.get(entry);
        }

        return entry;
    }
    //[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]

    public static void main(String[] args) {
        GoldmanSachsQuestion abc = new GoldmanSachsQuestion();
        System.out.println(abc.burst("aabcccdeee", 3));
    }
}
