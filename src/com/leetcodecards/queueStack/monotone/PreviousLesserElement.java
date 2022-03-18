package com.leetcodecards.queueStack.monotone;

import java.util.*;

public class PreviousLesserElement {

    public int[] ple(int[] a) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int len = a.length;
        int[] res = new int[len];

        for(int i = len-1; i >= 0; i--) {
            while(!stack.isEmpty() && a[stack.peek()] >= a[i])
                res[stack.pop()] = a[i];

            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        PreviousLesserElement abc = new PreviousLesserElement();

        System.out.println(Arrays.toString(abc.ple(new int[] {10,20,15,17,21,9,4100})));
    }
}
