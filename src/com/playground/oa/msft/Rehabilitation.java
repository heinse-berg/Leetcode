package com.playground.oa.msft;

import java.util.*;

public class Rehabilitation {
    //https://leetcode.com/discuss/interview-question/2055241/Microsoft-or-SDE-1-or-OA-2022

    public Integer dp(int[] a, int x, int y, int i) {

        if(x == 0)
            return 0;

        if(i == a.length)
            return null;

        int cost = Integer.MAX_VALUE;

        if((i + ((x-1)*y)) < a.length)
            cost = Math.min(cost, dp(a, x-1, y, i+y) + a[i]);
        cost = Math.min(cost, dp(a, x, y, i+1));

        return cost;

    }

    public int rehab(int[] a, int x, int y) {
        int cost = Integer.MAX_VALUE;

        int n = a.length;
        for(int i = 0; i < n; i++)  {

            if((i + ((x-1)*y)) < a.length) {

                int c = 0;
                for(int j = i,ct = 0; ct < x; j += y,ct++) {
                    c += a[j];
                }
                cost = Math.min(c, cost);
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        Rehabilitation a = new Rehabilitation();
        System.out.println(a.rehab(new int[] {4,2,5,4,3,5,1,4,2,7}, 3, 2));
    }
//A = [4,2,3,7] X = 2 Y = 2
//o/p 7 (sum of cost of day 0 and 2);
//
//A = [10, 3 ,4, 7] X = 2 Y = 3
//o/p 17 (sum of day 0 and day 3)
//
//A = [4,2,5,4,3,5,1,4,2,7] X = 3 Y = 2
//6 (day 4, 6 , 8)
}
