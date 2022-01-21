package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class MaxDoubles {
    int target;
    int maxDoubles;

    public int helper(int target, int maxDoub) {
        if(target == 1)
            return 0;


        int increment = helper(target-1, maxDoub) + 1;
        int doub = Integer.MAX_VALUE;

        if(maxDoub > 0 && target%2 == 0) {
            maxDoub--;
            doub = helper(target/2, maxDoub) + 1;
        }
        return Math.min(increment, doub);
    }

    public int minMoves(int target, int maxDoubles) {
        this.target = target;
        this.maxDoubles = maxDoubles;

        return helper(target, maxDoubles);
    }

    public static void main(String[] args) {
        MaxDoubles abc = new MaxDoubles();
        System.out.println(abc.minMoves(19,2));
    }
}
