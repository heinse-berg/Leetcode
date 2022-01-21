package com.leetcode;

import java.util.*;

public class P_735 {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[0]);
        int i = 1, top;
        while(i < asteroids.length) {
            if(stack.isEmpty())
                stack.push(asteroids[i++]);
            top = stack.peek();
            int temp = asteroids[i];
            if((temp > 0 && top > 0) || (temp < 0 && top < 0)) {
                stack.push(asteroids[i++]);
            }
            else if(top > 0  && temp < 0 && temp == -top) {
                stack.pop(); i++;
            }
            else {
                if(top < 0 && temp > 0) {
                    stack.push(temp); i++;
                }
                else if(top > 0 && temp < 0) {
                    if (top > Math.abs(temp)){
                        i++;
                    } else if (top < Math.abs(temp)){
                        while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(temp))
                            stack.pop();
                        if(!stack.isEmpty() && stack.peek() > 0 && stack.peek() > Math.abs(temp))
                            i++;
                        else if(!stack.isEmpty() && stack.peek() == Math.abs(temp)) {
                            stack.pop(); i++;
                        }
                        else {
                            stack.push(temp); i++;
                        }
                    }
                }
            }
        }
        int[] res = new int[stack.size()]; i = 0;
        Stack<Integer> temp = new Stack<>();
        while(!stack.isEmpty())
            temp.push(stack.pop());
        while(!temp.isEmpty())
            res[i++] = temp.pop();
        return res;
    }

    public static void main(String[] args) {
        P_735 abc = new P_735();
        /*System.out.println(Arrays.toString(abc.asteroidCollision(new int[]{10,2,-5})));
        System.out.println(Arrays.toString(abc.asteroidCollision(new int[]{5,10,-5})));*/
        System.out.println(Arrays.toString(abc.asteroidCollision(new int[]{-2,-2,1,-2})));
    }
}
