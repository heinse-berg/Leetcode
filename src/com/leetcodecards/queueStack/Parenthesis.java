package com.leetcodecards.queueStack;

import java.util.*;

public class Parenthesis {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if( c == '}' && (stack.isEmpty() || !stack.pop().equals('{')) )
                return false;
            else if(c == ']' && (stack.isEmpty() || !stack.pop().equals('[')) )
                return false;
            else if(c == ')' && (stack.isEmpty() || !stack.pop().equals('(')) )
                return false;

            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Parenthesis abc = new Parenthesis();
        System.out.println();
    }
}
