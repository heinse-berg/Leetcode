package com.leetcodecards.sliding.window;

import java.util.*;

class Solution {

    public String minWindow(String s, String t) {

        int left = 0, right = 0, n = s.length(), m = t.length(), unique, uniqueMatch = 0;
        int[] a = new int[3]; a[0] = Integer.MAX_VALUE;
        HashMap<Character, Integer> substringMap = new HashMap<>(), stringMap = new HashMap<>();
        for(char c : t.toCharArray())
            substringMap.put(c, substringMap.getOrDefault(c, 0) + 1);
        unique = substringMap.keySet().size();

        while(right < n) {
            char c = s.charAt(right);
            stringMap.put(c, stringMap.getOrDefault(c, 0)+1);
            if(substringMap.containsKey(c) && Objects.equals(stringMap.get(c), substringMap.get(c)))
                uniqueMatch++;

            while(unique == uniqueMatch && left < n) {
                if(a[0] > right-left+1) {
                    a[0] = right - left + 1;
                    a[1] = left;
                    a[2] = right;
                }
                char l = s.charAt(left);
                stringMap.put(l, stringMap.getOrDefault(l, 0)-1);
                if(substringMap.containsKey(l) && stringMap.get(l) < substringMap.get(l))
                    uniqueMatch--;
                left++;
            }

            right++;
        }
        return a[0] == Integer.MAX_VALUE ? "" :  s.substring(a[1], a[2]+1);
    }

    public static void main(String[] args) {
        Solution abc = new Solution();
        System.out.println(abc.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(abc.minWindow("A", "AA"));
        System.out.println(abc.minWindow("A", "A"));
    }
}
