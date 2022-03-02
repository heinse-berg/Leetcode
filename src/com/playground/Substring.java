package com.playground;

import java.util.*;

public class Substring {

    public int substring(String a) {

        HashSet<String> substrings = new HashSet<>();
        int n = a.length(), max = 0;

        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = i; j < n; j++) {
                sb.append(a.charAt(j));
                if(substrings.contains(sb.toString()))
                    max = Math.max(max, sb.length());
                substrings.add(sb.toString());
            }
        }

        return max;
    }

    //abcd n=4
    /*
    ab n = 2
    a ab
    b

    abc n = 3
    a ab abc 6
    b bc 3
    c 1

    abcd

    a ab abc abcd 10
    b bc bcd 6
    c cd
    d

    O(n^2) * n = O(n^3) for bytes
     */
    //a ab abc abcd //b bc bcd //c cd //d

    public static void main(String[] args) {
        Substring abc = new Substring();
        System.out.println(abc.substring( "aaaa"));
    }
}
