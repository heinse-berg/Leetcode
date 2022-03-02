package com.leetcodecards.sliding.window;

import java.util.*;

public class CharacterReplacement {

    public int characterReplacement(String s, int k) {

        int n = s.length(), max = 0, left = 0, maxF = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for(int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            maxF = Math.max(maxF, map.get(ch));

            while((right-left+1) - maxF > k) {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }

            max = Math.max(max, right-left+1);
        }

        return max;
    }

    public static void main(String[] args) {
        CharacterReplacement abc = new CharacterReplacement();
        System.out.println(abc.characterReplacement("aaaedcabqrst", 3));
    }
}
