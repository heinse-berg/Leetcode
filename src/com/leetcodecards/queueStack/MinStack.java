package com.leetcodecards.queueStack;

import java.util.*;

public class MinStack {

    Stack<Integer> stack, minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty() || minStack.peek() >= val)
            minStack.push(val);
        stack.push(val);
    }

    public void pop() {
        if(stack.pop().equals(minStack.peek()))
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack abc = new MinStack();
        System.out.println();
    }
}
