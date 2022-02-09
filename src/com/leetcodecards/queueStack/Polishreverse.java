package com.leetcodecards.queueStack;

import java.util.*;

public class Polishreverse {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s : tokens) {
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "/":
                    int x = stack.pop(), y = stack.pop();
                    stack.push(y / x);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Polishreverse abc = new Polishreverse();
        System.out.println(abc.evalRPN(new String[]{
                "10","6","9","3","+","-11","*","/","*","17","+","5","+"
        }));
    }
}
