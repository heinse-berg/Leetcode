package com.playground;

import java.util.*;

public class StringMatching {

    public int naive(String text, String pat) {
        int i = 0, j, count = 0, n = text.length(), m = pat.length();
        for(; i <= (n-m); i++) {
            for(j = 0; j < m; j++) {
                if(text.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if(j == m)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        StringMatching abc = new StringMatching();
        System.out.println(abc.naive("aabaa", "aabaa"));
    }
}
