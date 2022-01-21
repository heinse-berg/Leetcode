package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class Tribonacci {

    public int tribonacci(int n) {
        if(n < 2) return n;
        if(n == 2) return 1;

        int i;
        int[] trib = new int[n+1];
        trib[0] = 0;trib[1] = 1;trib[2] = 1;
        for(i = 3; i < n; i++) {
            trib[i] = trib[i-1] + trib[i-2] + trib[i-3];
        }
        return trib[n];
    }


    public static void main(String[] args) {
        Tribonacci abc = new Tribonacci();
        System.out.println(abc.tribonacci(4));
    }
}
