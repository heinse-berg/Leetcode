package com.leetcodecards.trie;

import javafx.util.Pair;

import java.util.*;

public class autocompleteSystem {

    static class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        HashMap<String, Integer> pq = new HashMap<>();
    }

    TrieNode root;
    StringBuilder current = new StringBuilder();

    public autocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();

        for(int i = 0; i < sentences.length ; i++) {
            TrieNode curr = root;

            for(char c : sentences[i].toCharArray()) {
                if(!curr.map.containsKey(c)) {
                    curr.map.put(c, new TrieNode());
                }
                curr.pq.put(sentences[i], curr.pq.getOrDefault(sentences[i], 0) + times[i]);
                curr = curr.map.get(c);
            }
            curr.pq.put(sentences[i], curr.pq.getOrDefault(sentences[i], 0) + times[i]);
        }

    }

    public List<String> input(char c) {
        List<String> res = new LinkedList<>();

        if(c == '#') {
            TrieNode curr = root;
            String s = current.toString();

            for(char ch : s.toCharArray()) {
                if(!curr.map.containsKey(ch)) {
                    curr.map.put(ch, new TrieNode());
                }
                curr.pq.put(s, curr.pq.getOrDefault(s, 0) + 1);
                curr = curr.map.get(ch);
            }
            curr.pq.put(s, curr.pq.getOrDefault(s, 0) + 1);
            current = new StringBuilder();
            return res;
        }


        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>((a, b) ->
                a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        TrieNode curr = root;
        current.append(c);

        for(char ch : current.toString().toCharArray()) {
            if(!curr.map.containsKey(ch))
                return res;
            curr = curr.map.get(ch);
        }

        for(Map.Entry<String, Integer> entry : curr.pq.entrySet())
            pq.add(new Pair<>(entry.getKey(), entry.getValue()));


        int sz = pq.size();

        for(int i = 0; i < Math.min(3, sz); i++)
            res.add(pq.poll().getKey());

        return res;
    }

    public static void main(String[] args) {
        autocompleteSystem abc = new autocompleteSystem(new String[] {"abc", "abbc", "a"}, new int[] {3,3,3});
        char[] array = new char[] {'b', 'c', '#', 'b', 'c', '#'};
        for(char c : array)
            System.out.println(abc.input(c));
    }
    /*
    ["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input"]
[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"]]
     */
}
//
