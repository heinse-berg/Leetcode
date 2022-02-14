package com.leetcodecards.queueStack;

import java.util.*;

public class DecodeEncode {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ']') {
                StringBuilder sb = new StringBuilder(), t = new StringBuilder();
                while(!stack.peek().equals("["))
                    sb.insert(0, stack.pop());
                stack.pop();
                StringBuilder num = new StringBuilder();
                while(!stack.isEmpty() && stack.peek().matches("\\d"))
                    num.insert(0, stack.pop());
                int k = Integer.parseInt(num.toString());
                for(int j = 0; j < k; j++)
                    t.append(sb);
                stack.push(t.toString());
            }
            else
                stack.push(String.valueOf(c));
        }

        while(!stack.isEmpty())
            ans.insert(0, stack.pop());

        return ans.toString();
    }

    public static void main(String[] args) {
        DecodeEncode abc = new DecodeEncode();
        System.out.println(abc.decodeString("3[a2[c]]"));
        System.out.println(abc.decodeString("3[a]2[bc]"));
        System.out.println(abc.decodeString("2[abc]3[cd]ef"));
        System.out.println(abc.decodeString("11[leetcode]"));
    }
}
