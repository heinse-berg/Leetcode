package com.leetcodecards.bin.trees;

import com.leetcodecards.recursion1.TreeNode;

import java.util.*;

public class TreeFromString {

    public TreeNode str2tree(String s) {
        int i, len = s.length(), j;
        char c;
        Stack<TreeNode> stack = new Stack<>(); String num;

        for(i = 0; i < len; ) {
            c = s.charAt(i);
            if(c == ')') {
                stack.pop();
                i++;
            }
            else if((c >= '0' && c <= '9' || c == '-')){
                    j = i;
                    while(i < s.length() && ((s.charAt(i) >= '0' && s.charAt(i) <= '9') || s.charAt(i) == '-'))
                        i++;
                    num = s.substring(j, i);
                    TreeNode n = new TreeNode(Integer.parseInt(num));
                    if(!stack.isEmpty()) {
                        TreeNode parent = stack.peek();
                        if(parent.left == null)
                            parent.left = n;
                        else parent.right = n;
                    }
                    stack.push(n);
            }
            else i++;
        }

        return stack.isEmpty() ? null : stack.peek();
    }

    public static void main(String[] args) {
        TreeFromString abc = new TreeFromString();
        abc.str2tree("-4(2(3)(1))(6(5)(7))");
        System.out.println();
    }
}
