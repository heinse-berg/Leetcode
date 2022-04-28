package com.leetcode.company.amazon;

import java.util.*;

public class PasswordStrength {

    //https://leetcode.com/discuss/interview-question/1594897/amazon-oa-questions-find-password-strength

    public int findStrength(String password) {

        int len = password.length(), strength = 0;

        for(int windowSize = 1; windowSize <= len; windowSize++) {

            HashMap<Character, Integer> map = new HashMap<>();
            int count = 0, index;

            for(index = 0; index < windowSize; index++) {

                char c = password.charAt(index);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            count += map.size();

            for(; index < len; index++) {

                char toRemove = password.charAt(index - windowSize);
                int prevCount = map.get(toRemove);
                map.put(toRemove, --prevCount);
                if(prevCount == 0)
                    map.remove(toRemove);

                char curr = password.charAt(index);
                map.put(curr, map.getOrDefault(curr, 0) + 1);
                count += map.size();
            }

            strength += count;
        }

        return strength;
    }

    public static void main(String[] args) {
        System.out.println(new PasswordStrength().findStrength("good"));
    }

}
