package com.leetcodecards.trie;

import java.util.*;

public class MapSum {

    static class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        int val;
    }

    TrieNode root;

    public MapSum() {
        this.root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode curr = root;
        for(char c : key.toCharArray()) {
            if(!curr.map.containsKey(c)) {
                TrieNode child = new TrieNode();
                child.val += val;
                curr.map.put(c, child);
            }
            curr = curr.map.get(c);
        }
    }

    public int sum(String prefix) {
        int sum = 0;
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            if(!curr.map.containsKey(c))
                return 0;
            sum += curr.val;
            curr = curr.map.get(c);
        }
        return sum;
    }

    public static void main(String[] args) {
        MapSum abc = new MapSum();
        System.out.println();
    }
}
