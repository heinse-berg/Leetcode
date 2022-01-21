package com.leetcode;

public class P_38 {
    public String countAndSay(int n) {
        String s = "1";
        for(int i = 1; i < n; i++) {
            s = say(s);
        }
        return s;
    }

    private String say(String n) {
        StringBuilder ans = new StringBuilder();
        int count, j;
        for (int i = 0; i < n.length(); ) {
            char a = n.charAt(i);
            j = i;
            while(j < n.length() && n.charAt(i) == n.charAt(j))
                j++;
            count = j - i;
            ans.append(count).append(a);
            if(i == j+1)
                i++;
            else
                i = j;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        //enter code
        System.out.println(new P_38().countAndSay(3));
    }
}
