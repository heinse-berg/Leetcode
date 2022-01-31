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

        int i, j;
        HashMap<Character, HashSet<Character>> outDegree = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();

        for(String word : words) {
            for(char c : word.toCharArray()) {
                inDegree.put(c, 0);
                outDegree.put(c, new HashSet<>());
            }
        }

        for (i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            for (j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    char prev = word1.charAt(j);
                    char next = word2.charAt(j);
                    if(!outDegree.get(prev).contains(next)) {
                        outDegree.get(prev).add(next);
                        inDegree.put(next, inDegree.get(next) + 1);
                    }
                    break;
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.addLast(entry.getKey());
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.pollFirst();
            res.append(c);
            for (char ch : outDegree.get(c)) {
                inDegree.put(ch, inDegree.get(ch) - 1);
                if(inDegree.get(ch) == 0)
                    queue.addLast(ch);
            }
        }

        return res.length() == inDegree.size() ? res.toString() : "";
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
