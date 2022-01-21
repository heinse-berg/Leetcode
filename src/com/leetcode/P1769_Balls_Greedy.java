package com.leetcode;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
public class P1769_Balls_Greedy {

    public int[] minOperations(String boxes) {
        int i, j, length = boxes.length();
        int[] res = new int[length];
        for(i = 0; i < length; i++) {
            for(j = 0; j < length; j++)
                if(boxes.charAt(j) == '1' && j != i)
                    res[i] += Math.abs(j-i);
        }
        return res;
    }

    public static void main(String[] args) {
        String boxes = "110";
        System.out.println(Arrays.toString(new P1769_Balls_Greedy().minOperations(boxes)));
    }
}
