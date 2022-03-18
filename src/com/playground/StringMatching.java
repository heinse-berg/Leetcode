package com.playground;

public class StringMatching {

    public int naive(String text, String pat) {
        int i = 0, j, count = 0, n = text.length(), m = pat.length();
        for(; i <= (n-m); i++) {
            for(j = 0; j < m; j++) {
                if(text.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if(j == m)
                count++;
        }
        return count;
    }

    public int myAtoi(String s) {
        s = s.trim();
        int i = 0, n = s.length(), start = 0;
        boolean neg = false;
        if(n == 0)
            return 0;
        char c = s.charAt(0);
        if(c == '-' || c == '+') {
            if(c == '-')
                neg = true;
            i++; start++;
        }

        while(i < n && Character.isDigit(s.charAt(i)))
            i++;
        s = s.substring(start, i);
        long val = Long.parseLong(s);
        if(s.length() == 0)
            return 0;
        if(neg)
            val = -val;
        if(val > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(val < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) val;
    }

    public static void main(String[] args) {
        StringMatching abc = new StringMatching();
        System.out.println(abc.naive("aabaa", "aabaa"));
    }
}
