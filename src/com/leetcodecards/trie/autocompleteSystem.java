package com.leetcodecards.trie;

import javafx.util.Pair;

import java.util.*;

public class autocompleteSystem {

    /*class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
    }

    TrieNode root;*/
    StringBuilder letters;
    HashMap<String, Integer> map = new HashMap<>();

    public autocompleteSystem(String[] sentences, int[] times) {
        //root = new TrieNode();
        letters = new StringBuilder();
        for(int i = 0; i < sentences.length; i++) {
            map.put(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c == '#') {
            map.put(letters.toString(), map.getOrDefault(letters.toString(), 0) + 1);
            letters = new StringBuilder();
            return new ArrayList<>();
        }

        LinkedList<Pair<String, Integer>> pq = new LinkedList<>();
          Comparator<Pair<String, Integer>> co = ( (a,b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue() );

        String s = letters.append(c).toString();
        List<String> res = new LinkedList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            if(key.startsWith(s)) {
                pq.add(new Pair<>(key, value));
            }
        }
        pq.sort(co);
        int i = 0;
        while(i < Math.min(pq.size(), 3)) {
            res.add(pq.get(i).getKey());
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        autocompleteSystem abc = new autocompleteSystem(new String[] {"i love you", "island", "ironman", "i love leetcode"}, new int[] {5, 3, 2, 2});
        char[] array = new char[] {'i', ' ', 'a', '#','i',' ', 'a', '#', 'i', ' ', 'a', '#'};
        for(char c : array)
            System.out.println(abc.input(c));
    }
    /*
    ["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input"]
[[["i love you","island","iroman","i love leetcode"],[5,3,2,2]],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"],["i"],[" "],["a"],["#"]]
     */
}
//
