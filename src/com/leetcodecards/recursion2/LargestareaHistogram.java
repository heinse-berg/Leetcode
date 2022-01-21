package com.leetcodecards.recursion2;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestareaHistogram {

    public int largestRectangleAreaBruteForce(int[] heights) {
        int i, j, k, len = heights.length, minHeight;
        int maxArea = Integer.MIN_VALUE;
        for(i = 0; i < len; i++) {
            minHeight = Integer.MAX_VALUE;
            for(j = i; j < len; j++) {
                minHeight = Math.min(minHeight, heights[j]);
                maxArea = Math.max(maxArea, minHeight*(j-i+1));
            }
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int length = heights.length;
        int maxArea = 0;
        for (int i = 0; i < length; i++) {
            while ((stack.peek() != -1)
                    && (heights[stack.peek()] >= heights[i])) {
                int currentHeight = heights[stack.pop()];
                int currentWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currentHeight * currentWidth);
            }
            stack.push(i);
        }
        while (stack.peek() != -1) {
            int currentHeight = heights[stack.pop()];
            int currentWidth = length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currentHeight * currentWidth);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        //[2,1,5,6,2,3]
        LargestareaHistogram abc = new LargestareaHistogram();
        int[] array = new int[]{5,15,25,35,30,20};
        System.out.println(abc.largestRectangleArea(array));
    }
}
