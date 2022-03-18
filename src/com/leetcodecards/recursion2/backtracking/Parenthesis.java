package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class Parenthesis {

    LinkedList<String> res = new LinkedList<>();

    public void backtrack(int n, StringBuilder cur, int open, int close) {

        if(cur.length() == 2 * n) {
            res.add(cur.toString());
            return;
        }

        if(open < n) {
            cur.append("(");
            backtrack(n, cur, open + 1, close);
            cur.deleteCharAt(cur.length() - 1);
        }

        if(open > close) {
            cur.append(")");
            backtrack(n, cur, open, close+1);
            cur.deleteCharAt(cur.length()-1);
        }

    }

    public List<String> generateParenthesis(int n) {
        backtrack(n, new StringBuilder(), 0, 0);
        return res;
    }
    public static void main(String[] args) {
        Parenthesis abc = new Parenthesis();
        System.out.println(abc.generateParenthesis(3));
    }
}
