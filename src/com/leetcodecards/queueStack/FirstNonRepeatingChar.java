package com.leetcodecards.queueStack;

import java.util.*;

public class FirstNonRepeatingChar {

    public String FirstNonRepeating(String a)
    {
        int[] count = new int[26];
        Arrays.fill(count, -1);
        StringBuilder res = new StringBuilder();
        int n = a.length();
        LinkedList<Character> queue = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            char c = a.charAt(i);
            if(count[c-'a'] == -1) {
                count[c-'a'] = i;
                queue.addLast(c);
            }
            else if(count[c-'a'] != -1) {
                if(queue.contains(c))
                    queue.remove((Character) c);
            }
            if(queue.isEmpty())
                res.append('#');
            else
                res.append(queue.getFirst());
        }

        return res.toString();
    }

    public static void main(String[] args) {
        FirstNonRepeatingChar abc = new FirstNonRepeatingChar();
        System.out.println(abc.FirstNonRepeating("aabcbbdceedcece"));
    }
}
