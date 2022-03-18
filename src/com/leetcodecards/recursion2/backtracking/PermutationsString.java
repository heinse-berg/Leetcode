package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class PermutationsString {

    LinkedList<String> res = new LinkedList<>();
    int n;

    public void back(StringBuilder curr, StringBuilder s, boolean[] visited) {
        if(curr.length() == n) {
            res.addLast(curr.toString());
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                curr.append(s.charAt(i));
                back(curr, s, visited);
                curr.deleteCharAt(curr.length()-1);
                visited[i] = false;
            }
        }
    }

    public List<String> find_permutation(String S) {
        n = S.length();
        back(new StringBuilder(), new StringBuilder(S), new boolean[n]);
        return res;
    }

    public static void main(String[] args) {
        PermutationsString abc = new PermutationsString();
        System.out.println(abc.find_permutation("ABC"));
    }
}
