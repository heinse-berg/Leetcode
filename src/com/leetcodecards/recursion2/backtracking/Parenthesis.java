package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class Parenthesis {

    List<String> res = new ArrayList<>();
    int n;
    
    public List<String> parenthesis(int n) {
        this.n = n;
        createList(new StringBuilder(), 0, 0);
        return res;
    }

    public void createList(StringBuilder curr, int open, int close) {
        if(curr.length() == 2 * n) {
            res.add(curr.toString());
        }

        if(open < n) {
            curr.append('(');
            createList(curr, open+1, close);
            curr.deleteCharAt(curr.length()-1);
        }
        if(close < open) {
            curr.append(')');
            createList(curr, open, close+1);
            curr.deleteCharAt(curr.length()-1);
        }
    }

    public List<String> iterative(int n) {
        Stack<Character> stack = new Stack<>();
        int open = 0, close = 0;
        StringBuilder curr = new StringBuilder();

        while(open < n && close <= open) {
            if(curr.length() == 2 * n)
                res.add(curr.toString());
            if(open < n) {
                open++;
                curr.append('(');
            }
            if(close < open) {
                close++;
                curr.append(')');
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Parenthesis abc = new Parenthesis();
        System.out.println(abc.parenthesis(3));
    }
}
