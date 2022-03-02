package com.leetcodecards.graph.kahns;

import java.util.*;
/*
There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.

You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.

Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.

A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length
 */

public class Alien{

    public String alienOrder(String[] words) {

        int i, j, n = words.length;
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        StringBuilder res = new StringBuilder();
        ArrayDeque<Character> deque = new ArrayDeque<>();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                if(!graph.containsKey(c)) {
                    graph.put(c, new HashSet<>());
                    inDegree.put(c, 0);
                }
            }
        }

        for(i = 0; i < n-1; i++) {
            String word1 = words[i]; int n1 = word1.length();
            String word2 = words[i+1]; int n2= word2.length();

            if(n1 > n2 && word1.startsWith(word2))
                return "";

            for(j = 0; j < Math.min(n1, n2); j++) {
                char c1 = word1.charAt(j), c2 = word2.charAt(j);
                if(c1 != c2) {
                    if(!graph.get(c1).contains(c2)) {
                        graph.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        for(char c : inDegree.keySet()) {
            if(inDegree.get(c).equals(0))
                deque.addLast(c);
        }

        while(!deque.isEmpty()) {
            char c = deque.pollFirst();
            res.append(c);
            for(char child : graph.get(c)) {
                inDegree.put(child, inDegree.get(child)-1);
                if(inDegree.get(child).equals(0))
                    deque.addLast(child);
            }
        }

        return res.length() == inDegree.size() ? "" : res.toString();
    }

    public static void main(String[] args) {
        Alien abc = new Alien();
        /*System.out.println(abc.alienOrder(new String[] {"wrt","wrf","er","ett","rftt"}));
        System.out.println(abc.alienOrder(new String[] {"zw", "wz", "z"}));
        System.out.println(abc.alienOrder(new String[] {"z", "z", "z"}));
        System.out.println(abc.alienOrder(new String[] {"zwa", "abc"}));*/
        System.out.println(abc.alienOrder(new String[] {"ac","ab","zc","zb"}));
        System.out.println(abc.alienOrder(new String[] {"abc", "ab"}));
    }
}
