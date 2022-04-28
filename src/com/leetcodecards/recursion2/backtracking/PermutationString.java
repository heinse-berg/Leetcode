package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class PermutationString {

    public void backtrack(StringBuilder sb, LinkedList<String> res, int n, int i) {
        if(i == n) {
            res.addLast(sb.toString());
            return;
        }

        char c = sb.charAt(i);

        if (Character.isLetter(c)) {
            backtrack(sb, res, n, i+1);

            if (Character.isUpperCase(c))
                sb.setCharAt(i, Character.toLowerCase(c));
            else
                sb.setCharAt(i, Character.toUpperCase(c));

            backtrack(sb, res, n, i + 1);
            sb.setCharAt(i, c);
        }
        else
            backtrack(sb, res, n, i+1);
    }

    public List<String> letterCasePermutation(String s) {
        LinkedList<String> res = new LinkedList<>();
        backtrack(new StringBuilder(s), res, s.length(), 0);
        return res;
    }

    public static void main(String[] args) {
        PermutationString abc = new PermutationString();
        System.out.println(abc.letterCasePermutation("abc"));
    }
}
