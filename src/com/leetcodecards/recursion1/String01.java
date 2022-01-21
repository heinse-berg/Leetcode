package com.leetcodecards.recursion1;

import java.util.*;

public class String01 {
    int n;
    StringBuilder sb;

    public void helper(TreeNode node, int k) {
        if(n == k) {
            sb.append(node.val);
            return;
        }
        if(node.val == 0) {
            node.left = new TreeNode(0);
            node.right = new TreeNode(1);
        }
        else {
            node.left = new TreeNode(1);
            node.right = new TreeNode(0);
        }
        helper(node.left, k+1);
        helper(node.right, k+1);
    }

    public int a(int n) {
        this.n = n;
        this.sb = new StringBuilder();
        helper(new TreeNode(0), 0);
        return Integer.parseInt(String.valueOf(sb.toString().charAt(n - 1)));
    }

    public static void main(String[] args) {
        String01 abc = new String01();
        System.out.println(abc.a(2));
        System.out.println(abc.a(3));
        System.out.println(abc.a(4));
    }
}
