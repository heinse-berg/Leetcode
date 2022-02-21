package com.leetcode.contest;

import java.util.*;

public class SmallestValue {
    public long smallestNumber(long num) {
        if(num == 0)
            return 0;

        long[] counts = new long[10];
        boolean flag = num < 0;
        long ans = 0;

        if(num < 0)
            num = -num;

        while(num > 0) {
            counts[(int)(num%10)]++;
            num /= 10;
        }

        if(!flag) {
            if(counts[0] > 0) {
                int i = 1;
                while(counts[i] == 0)
                    i++;
                ans = i;
                counts[i]--;
            }
            for(int i = 0; i < 10; i++) {
                while(counts[i] > 0) {
                    ans = (ans*10) + i;
                    counts[i]--;
                }
            }
        }

        else {
            for(int i = 9; i >= 0; i--) {
                while(counts[i] > 0) {
                    ans = (ans*10) + i;
                    counts[i]--;
                }
            }
            ans = -ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        SmallestValue abc = new SmallestValue();
        System.out.println(abc.smallestNumber(5059L));
    }
}
