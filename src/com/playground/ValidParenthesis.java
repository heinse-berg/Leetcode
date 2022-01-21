package com.playground;

import java.util.Stack;

public class ValidParenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
            if(c == '(') stack.push(c);
            else
                if(stack.isEmpty()) return false;
                else stack.pop();

        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        ValidParenthesis abc = new ValidParenthesis();
        System.out.println(abc.isValid("((()))"));
        System.out.println(abc.isValid("(()())"));
        System.out.println(abc.isValid("(())()"));
        System.out.println(abc.isValid("((()))"));
        System.out.println(abc.isValid("((())))"));
        System.out.println(abc.isValid(")))"));
        System.out.println(abc.isValid(")))((("));
        System.out.println(abc.isValid("((())"));
    }
}
