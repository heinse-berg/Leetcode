package com.leetcodecards.arrayandstring;

import java.util.*;

public class ConsecutiveStrings {

    public int ans(String a, char ch) {
        int i = 0, n = a.length(), res = 0;

        if(a.charAt(0) != ch)
            res += 2;

        while(i < n-1) {
            char curr = a.charAt(i);
            char next = a.charAt(i+1);

            if(curr != ch && next != ch) {
                res += 2;
                i++;
            }
            else if(curr == ch && next == ch)
                i += 2;
            else {
                if(curr == ch) {
                    res++;
                    i++;
                }
                else {
                    res++;
                    i += 2;
                }
            }
        }

        if(a.charAt(n-1) != ch)
            res += 2;

        return res;
    }

    public static void main(String[] args) {
        ConsecutiveStrings abc = new ConsecutiveStrings();
        System.out.println(abc.ans("ccb", 'b'));
        System.out.println(abc.ans("bccb", 'b'));
        System.out.println(abc.ans("cat", 'b'));
        System.out.println(abc.ans("bcab", 'b'));
        System.out.println(abc.ans("bcbab", 'b'));
        System.out.println(abc.ans("bbbcbab", 'b'));
    }
}
