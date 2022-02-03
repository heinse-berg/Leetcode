package com.leetcodecards.trie;

import java.util.*;

public class ReplaceWords {

    static class TrieNode {
        Map<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for(String s : dictionary) {
            TrieNode curr = root;
            for(char c : s.toCharArray()) {
                if(!curr.map.containsKey(c)) {
                    curr.map.put(c, new TrieNode());
                }
                curr = curr.map.get(c);
            }
            curr.isWord = true;
        }

        String[] words = sentence.split(" ");
        for(int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            TrieNode curr = root;
            for(char c : words[i].toCharArray()) {
                if(!curr.map.containsKey(c))
                    break;
                TrieNode child = curr.map.get(c);
                curr = child;
                sb.append(c);
                if(child.isWord)
                    break;
            }
            words[i] = curr.isWord ? sb.toString() : words[i];
        }
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        ReplaceWords abc = new ReplaceWords();
        System.out.println();
    }
}
