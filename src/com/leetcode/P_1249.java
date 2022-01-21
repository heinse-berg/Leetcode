package com.leetcode;

import java.util.Stack;

public class P_1249 {

    public String minRemoveToMakeValid(String p) {
        StringBuilder s = new StringBuilder(p);
        Stack<Integer> stack = new Stack<>();
        int n = s.length(), i;
        for(i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(i);
            else if(c == ')') {
                if(stack.isEmpty()) {
                    s.deleteCharAt(i);
                    n--;
                }
                else
                    stack.pop();
            }
        }
        while(!stack.isEmpty()) {
            s.deleteCharAt(stack.pop());
        }
        return s.toString();
    }

    public static void main(String[] args) {
        //enter code
        System.out.println(new P_1249().minRemoveToMakeValid(")))))((((((absdsgas((()))"));
    }
}
