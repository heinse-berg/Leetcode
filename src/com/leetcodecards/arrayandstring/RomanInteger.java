package com.leetcodecards.arrayandstring;

import java.util.*;

public class RomanInteger {

    public int romanToInt(String s) {
        /*
        I             1
V             5
X             10
L             50
C             100
D             500
M             1000
         */

        int n = s.length(), ans = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int i;
        for(i = 0; i < n-1; ) {
            char curr = s.charAt(i);
            char next = s.charAt(i+1);
            switch(curr) {
                case 'I':
                    if(next == 'V') {
                        ans += 4;
                        i = i+2;
                    }
                    else if(next == 'X') {
                        ans += 9;
                        i = i+2;
                    }
                    else {
                        ans += 1;
                        i++;
                    }
                    break;
                case 'X':
                    if(next == 'L') {
                        ans += 40;
                        i = i+2;
                    }
                    else if(next == 'C') {
                        ans += 90;
                        i = i+2;
                    }
                    else {
                        ans += 10;
                        i++;
                    }
                    break;
                case 'C':
                    if(next == 'D') {
                        ans += 400;
                        i = i+2;
                    }
                    else if(next == 'M') {
                        ans += 900;
                        i = i+2;
                    }
                    else {
                        ans += 100;
                        i++;
                    }
                    break;
                default:
                    ans += map.get(curr);
                    i++;
                    break;
            }
        }

        if(i == n-1)
            ans += map.get(s.charAt(i));

        return ans;
    }

    public static void main(String[] args) {
        RomanInteger abc = new RomanInteger();
        System.out.println(abc.romanToInt("LVIII"));
        System.out.println(abc.romanToInt("MCMXCIV"));
        System.out.println(abc.romanToInt("III"));
        System.out.println(abc.romanToInt("IX"));
        System.out.println(abc.romanToInt("VI"));
        System.out.println(abc.romanToInt("IV"));
        System.out.println(abc.romanToInt("MCDLXXVI"));

    }
}
