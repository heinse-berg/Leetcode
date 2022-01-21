package com.leetcodecards.arrayandstring;

import java.util.*;

public class ReverseWords {

    /*public String reverseWords(String s) {
        s = s.trim().replaceAll(" +", " ");
        String[] words = s.split(" ");
        String temp;
        int start = 0, end = words.length-1;
        while(start < end) {
            temp = words[start];
            words[start] = words[end];
            words[end] = temp;
        }
        StringBuilder ans = new StringBuilder();
        start = 0; end = words.length-1;

    }*/

    public static void main(String[] args) {
        ReverseWords abc = new ReverseWords();
        String a = "a  b c  d";
        String[] t = a.split(" ");
        System.out.println();
    }
}
