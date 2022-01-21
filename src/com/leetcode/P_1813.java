package com.leetcode;

import java.util.Arrays;

public class P_1813 {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if(Arrays.equals(s1, s2))
            return true;
        if(s1.length == s2.length)
            return false;
        if(s1.length == 1)
            return (s1[0].equals(s2[0])) || s1[0].equals(s2[s2.length - 1]);
        if(s2.length == 1)
            return (s2[0].equals(s1[0])) || s2[0].equals(s1[s1.length - 1]);
        int i = 0, j, k;
        if(s1.length > s2.length) {
            while(i < s2.length && s1[i].equals(s2[i]))
                i++;
            if(i == s2.length)
                return true;
            j = s2.length-1; k = s1.length - 1;
            while(j >= 0 && s2[j].equals(s1[k])) {
                j--; k--;
            }
            if(j == -1)
                return true;
            return i == j + 1;
        } else {
            while(i < s1.length && s1[i].equals(s2[i]))
                i++;
            if(i == s1.length)
                return true;
            j = s1.length-1; k = s2.length-1;
            while(j >= 0 && s1[j].equals(s2[k])) {
                j--; k--;
            }
            if(j == -1)
                return true;
            return i == j + 1;
        }
    }

    public static void main(String[] args) {
        /*
        "of"
"A lot of words"*/
        System.out.println(new P_1813().areSentencesSimilar("of words", "a lot of words"));
    }
}
