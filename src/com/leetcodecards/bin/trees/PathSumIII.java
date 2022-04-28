package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class PathSumIII {

    int ans = 0;

    public void helper(TreeNode root, int targetSum, int currSum, HashMap<Integer, Integer> map) {

        if(root == null)
            return;

        if(map.containsKey(targetSum - (currSum + root.val)))
            ans += map.get(targetSum - (currSum + root.val));

        map.put(currSum + root.val, map.getOrDefault(currSum + root.val, 0) + 1);

        if(root.left != null)
            helper(root.left, targetSum, currSum + root.val, map);

        if(root.right != null)
            helper(root.right, targetSum, currSum + root.val, map);

        map.put(currSum + root.val, map.getOrDefault(currSum + root.val, 0) - 1);
    }
    public int pathSum(TreeNode root, int targetSum) {

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        helper(root, targetSum, 0, map);
        return ans;
    }

    public static void main(String[] args) {
        PathSumIII abc = new PathSumIII();
        System.out.println();
    }
}
