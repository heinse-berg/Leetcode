package com.leetcodecards.arrayandstring;

public class P_14_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int i, j, k = 0;
        StringBuilder ans = new StringBuilder();
        char temp;

        for(i = 0; i < strs[0].length(); i++) {
            if(strs[0].length() > k) temp = strs[0].charAt(k);
            else return ans.toString();
            for(j = 1; j < strs.length; j++) {
                if(strs[j].length() <= k) return ans.toString();
                if(strs[j].charAt(k) != temp) return ans.toString();
            }
            ans.append(temp); k++;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        P_14_LongestCommonPrefix abc = new P_14_LongestCommonPrefix();
        System.out.println(abc.longestCommonPrefix(new String[] {"ab", "a"}));
    }
}
