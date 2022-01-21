package com.leetcodecards.recursion2.backtracking;

import java.util.*;

public class LetterCombinations {
    Map<Integer, StringBuilder> map = new HashMap<>();
    List<String> res = new ArrayList<>(); int len;
    String digits;

    public void initMap() {
        map.put(2, new StringBuilder("abc"));
        map.put(3, new StringBuilder("def"));
        map.put(4, new StringBuilder("ghi"));
        map.put(5, new StringBuilder("jkl"));
        map.put(6, new StringBuilder("mno"));
        map.put(7, new StringBuilder("pqrs"));
        map.put(8, new StringBuilder("tuv"));
        map.put(9, new StringBuilder("wxyz"));
    }

    public void letterComb(int digit, StringBuilder curr) {
        if(curr.length() == len) {
            res.add(curr.toString());
            return;
        }

        int a = Integer.parseInt(String.valueOf(digits.charAt(digit)));
        String current = map.get(a).toString();
        for(char c: current.toCharArray()) {
            curr.append(c);
            letterComb(digit+1, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public List<String> letterCombinations(String digits) {
        len = digits.length();
        if(len == 0) return res;
        initMap();
        this.digits = digits;
        letterComb(0, new StringBuilder());
        return res;
    }

    public static void main(String[] args) {
        LetterCombinations abc = new LetterCombinations();
        System.out.println(abc.letterCombinations("234"));
    }
}
