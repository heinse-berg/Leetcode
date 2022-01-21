package com.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem {
    public int findTheWinner(int n, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= n; i++)
            list.add(i);
        int i = 0, indexToBeRemoved = 0;
        while(list.size() != 1) {
            indexToBeRemoved = (i+ (k-1)) % n;
            list.remove(indexToBeRemoved);
            n--;
            i = indexToBeRemoved;
        }
        return (int)(list.toArray())[0];
    }

    public String truncateSentence(String s, int k) {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(s);
        int i = 0;
        StringBuilder ans = new StringBuilder();
        while(matcher.find() && i < k) {
            ans.append(matcher.group()).append(" ");
            i++;
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
    public boolean checkIfPangram(String sentence) {
        boolean arr[] = new boolean[26];
        int i;
        for(i = 0; i < sentence.length(); i++) {
            int num = sentence.charAt(i) - 'a';
            if(!arr[num])
                arr[num] = true;
        }
        for(i = 0; i < 25; i++) {
            if(!arr[i])
                return false;
        }
        return true;
    }

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i, num = 0;
        for(i = 0; i < costs.length; i++) {
            if(coins - costs[i] >= 0) {
                coins -= costs[i];
                num++;
            }
            else
                break;
        }
        return num;
    }

    public static void main(String[] args) {
        //enter code
        /*System.out.println(new Problem().findTheWinner(5, 2));
        System.out.println(new Problem().truncateSentence("hello world there pppp qqqq", 3));*/
        //System.out.println(new Problem().checkIfPangram("onrcsnlxckptsxffbyswujpamfltvmdoxovggepknmtacrjkkorjgvgtgaiaudspnpxkwikevmjeephhiyvnoymjwjfopovscbefecnoytjxfwasabwohqujwowmakpyuuqvgfab"));
        System.out.println(2^3);
    }
}
