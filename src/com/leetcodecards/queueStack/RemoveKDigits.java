package com.leetcodecards.queueStack;

import java.util.*;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int n = num.length(), i;

        for(i = 0; i < n; i++) {
            while(!stack.isEmpty() && stack.getLast() > num.charAt(i) && k > 0) {
                stack.removeLast();
                k--;
            }
            stack.addLast(num.charAt(i));
        }

        while(k > 0 && !stack.isEmpty()) {
            stack.removeLast();
            k--;
        }

        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.append(stack.removeFirst());
        }

        return String.valueOf(Integer.parseInt(ans.toString()));
    }

    public static void main(String[] args) {
        RemoveKDigits abc = new RemoveKDigits();
        System.out.println(abc.removeKdigits("1432219", 3));
    }
}
