package com.leetcodecards.queueStack;

import java.util.*;

public class Sort {

    public Stack<Integer> sort(Stack<Integer> s)
    {
        Stack<Integer> temp = new Stack<>();
        temp.push(s.pop());

        while(!s.isEmpty()) {
            if(s.peek() <= temp.peek())
                temp.push(s.pop());
            else {
                int t = s.pop();
                while(!temp.isEmpty() && temp.peek() <= t) {
                    s.push(temp.pop());
                }
                temp.push(t);
                while(!s.isEmpty() && s.peek() <= temp.peek()) {
                    temp.push(s.pop());
                }
            }
        }

        return temp;
    }

    public static void main(String[] args) {
        Sort abc = new Sort();
        Stack<Integer> s = new Stack<>();
        s.push(34);
        s.push(3);
        s.push(31);
        s.push(98);
        s.push(92);
        s.push(23);
        s.push(40);
        System.out.println(abc.sort(s));
    }
}
