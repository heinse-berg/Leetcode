package com.leetcodecards.trie;

import javafx.util.Pair;

import java.util.*;

public class AutocompleteSystem {

    static final Comparator<Pair<String, Integer>> comparator = Collections.reverseOrder(Comparator.comparingInt(Pair::getValue));
    TrieNode root= new TrieNode();
    StringBuilder currString = new StringBuilder();

    static class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        HashMap<String, Integer> sent = new HashMap<>();
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        int i = 0;
        for(String s : sentences) {
            TrieNode curr = root;
            for(char c : s.toCharArray()) {
                if(!curr.map.containsKey(c))
                    curr.map.put(c, new TrieNode());
                curr = curr.map.get(c);
                curr.sent.put(s, times[i]);
            }
            i++;
        }
    }

    public List<String> input(char c) {
        LinkedList<String> res = new LinkedList<>();
        TrieNode curr = root;

        if(c == '#') {
            String sentence = currString.toString();
            for(char ch : sentence.toCharArray()) {
                if(!curr.map.containsKey(ch))
                    curr.map.put(ch, new TrieNode());
                curr = curr.map.get(ch);
                curr.sent.put(sentence, curr.sent.getOrDefault(sentence, 0) + 1);
            }
            currString.setLength(0);
            return res;
        }

        currString.append(c);
        for(char ch : currString.toString().toCharArray()) {
            if(!curr.map.containsKey(ch))
                curr.map.put(ch, new TrieNode());
            curr = curr.map.get(ch);
        }

        PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>(comparator);
        for(Map.Entry<String, Integer> entry : curr.sent.entrySet())
            pq.add(new Pair<>(entry.getKey(), entry.getValue()));

        int size = pq.size();
        for(int i = 0; i < Math.min(3, size); i++)
            res.add(pq.poll().getKey());

        return res;
    }

    public static void main(String[] args) {
        AutocompleteSystem abc = new AutocompleteSystem(new String[] {"abc", "abbc", "a"}, new int[] {3,3,3});
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
