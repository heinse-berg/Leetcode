package com.leetcodecards.sliding.window;

import java.util.*;

public class LongestSubstringkCharcs {

public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int n = s.length(), max = 0, left = 0;
        if(n * k == 0)
            return max;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, i);
            if(map.size() == k+1) {
                int min = Collections.min(map.values());
                map.remove(s.charAt(min));
                left = min+1;
            }

            max = Math.max(max,  i-left+1);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestSubstringkCharcs abc = new LongestSubstringkCharcs();
        System.out.println(abc.lengthOfLongestSubstringKDistinct("eeccbbea", 3));
        System.out.println(abc.lengthOfLongestSubstringKDistinct("aa", 1));
        System.out.println(abc.lengthOfLongestSubstringKDistinct("bbeeccaabdd", 4));
    }
}
