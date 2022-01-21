package com.leetcodecards.arrayandstring;

import java.util.*;

public class RevWords {

    static void reverseWord(char[] words, int start, int end) {
        char temp;
        while(start < end) {
            temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++; end--;
        }
    }

    public String reverseWords(String s) {
        int start = 0, end;
        char[] words = s.toCharArray();
        while(start < words.length) {
            end = start;
            while(end < words.length && words[end] != ' ') {
                end++;
            }
            reverseWord(words, start, end-1);
            start = end;
            start++;
        }
        return new String(words);
    }

    public static void main(String[] args) {
        RevWords abc = new RevWords();
        System.out.println(abc.reverseWords("Let's take LeetCode contest"));
    }
}
