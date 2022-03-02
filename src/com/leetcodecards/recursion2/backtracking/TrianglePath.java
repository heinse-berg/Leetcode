package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class TrianglePath {

    LinkedList<String> result;
    StringBuilder triangle = new StringBuilder("ABC");

    public void backtrack(StringBuilder curr, int n) {

        if(curr.length() == n+2) {
            if(curr.charAt(curr.length()-1) == 'A')
                result.addLast(curr.toString());
            return;
        }

        for(int i = 0; i < 3; i++)
            if(triangle.charAt(i) != curr.charAt(curr.length()-1)) {
                curr.append(triangle.charAt(i));
                backtrack(curr, n);
                curr.deleteCharAt(curr.length()-1);
            }

    }

    public List<String> paths(int n) {
        result = new LinkedList<>();
        backtrack(new StringBuilder("A"), n);
        return result;
    }

    public static void main(String[] args) {
        TrianglePath abc = new TrianglePath();
        System.out.println(abc.paths(0));
        System.out.println(abc.paths(1));
        System.out.println(abc.paths(2));
        System.out.println(abc.paths(3));
        System.out.println(abc.paths(4));
        //System.out.println(abc.paths(5));
        //System.out.println(abc.paths(6));
    }
}
