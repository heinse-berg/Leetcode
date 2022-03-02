package com.leetcode.contest;

import java.util.*;

public class RepeatString {

    public String repeatLimitedString(String s, int repeatLimit) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        StringBuilder ans = new StringBuilder();
        int count = s.length(), i = 25, j;

        for(char c : s.toCharArray())
            map[c-'a']++;

        for(int k = 0 ; k < 26; k++)
            if(map[k] > -1)
                map[k]++;

        while(count != 0) {
            while(i >= 0 && map[i] <= 0)
                i--;

            j = 0;
            while(j < repeatLimit && map[i] > 0) {
                ans.append((char)('a' + i));
                j++; count--; map[i]--;
            }
            if(map[i] == 0)
                i--;
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        RepeatString abc = new RepeatString();
        System.out.println(abc.repeatLimitedString("cczzcac", 3));
    }
}
