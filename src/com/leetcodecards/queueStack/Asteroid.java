package com.leetcodecards.queueStack;

import java.util.LinkedList;

public class Asteroid {

    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> stack = new LinkedList<>();

        for(int asteroid : asteroids) {
            if(asteroid < 0) {
                while(!stack.isEmpty() && stack.getLast() > 0 && stack.getLast() <= -asteroid) {
                    int top = stack.getLast();
                    if(top == -asteroid)
                        break;
                    else
                        stack.removeLast();
                }
                if(!stack.isEmpty() && stack.getLast() > 0) {
                    if(stack.getLast() == -asteroid)
                        stack.removeLast();
                }
                else
                    stack.addLast(asteroid);

            }
            else
                stack.addLast(asteroid);
        }

        return stack.stream().mapToInt(a -> a).toArray();
    }

}
