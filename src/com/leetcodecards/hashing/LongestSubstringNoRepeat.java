package com.leetcodecards.hashing;

import java.util.*;

public class LongestSubstringNoRepeat {

    /*public int lengthOfLongestSubstring(String s) {
        int i, j = 0, len = s.length(), max = 0;
        char[] arr = s.toCharArray(); char c;
        HashMap<Character, Integer> map = new HashMap<>();
        for(i = 0; i < len && j < len; ) {
            for(; j < len; j++) {
                if(map.containsKey(arr[j])) {
                    max = Math.max(max, j-i);
                    break;
                }
                map.put(arr[j], j);
            }
            if(j == len)
                max = Math.max(max, j-i);
            map.put(arr[j], j);
            i++;
        }
        return max;
    }*/

    public int lengthOfLongestSubstring(String s) {
        int[] chars = new int[128];

        int left = 0;
        int right = 0;

        int res = 0;
        while (right < s.length()) {
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1) {
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);

            right++;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringNoRepeat abc = new LongestSubstringNoRepeat();
        System.out.println(abc.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(abc.lengthOfLongestSubstring("abcdabpqrd"));
    }
}
