package com.leetcodecards.hashing;

import java.util.*;

public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int i = 0, left = 0, len = s.length(), max = 0;
        char[] arr = s.toCharArray();
        int[] count = new int[128];

        while(i < len) {
            while(i < len && count[arr[i]] == 0) {
                count[arr[i]]++;
                i++;
            }

            max = Math.max(max, i-left);

            while(left < len && i< len && arr[left] != arr[i])
                left++;

            left++; i++;
        }


        return max;
    }

    public static void main(String[] args) {
        LongestSubstring abc = new LongestSubstring();
        System.out.println(abc.lengthOfLongestSubstring("tmmzuxt"));
    }
}
