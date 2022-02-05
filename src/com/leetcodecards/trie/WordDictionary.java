package com.leetcodecards.trie;

import java.util.*;

public class WordDictionary {

    static class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean isWord;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()) {
            if(!curr.map.containsKey(c)) {
                curr.map.put(c, new TrieNode());
            }
            curr = curr.map.get(c);
        }
        curr.isWord = true;
    }

    public boolean dfs(StringBuilder word, int index, TrieNode node) {
        if(index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c != '.') {
            if (!node.map.containsKey(c))
                return false;
            return dfs(word, index + 1, node.map.get(c));
        }
        else {
            for(Map.Entry<Character, TrieNode> entry : node.map.entrySet()) {
                word.setCharAt(index, entry.getKey());
                if(dfs(word, index+1, entry.getValue()))
                    return true;
            }
            word.setCharAt(index, '.');
            return false;
        }
    }

    public boolean search(String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder(word);
        return dfs(sb, 0, curr);
    }

    public static void main(String[] args) {
        WordDictionary abc = new WordDictionary();
        abc.addWord("ran"); abc.addWord("rune"); abc.addWord("runner"); abc.addWord("runs");abc.addWord("add");
        abc.addWord("adds"); abc.addWord("adder"); abc.addWord("addee");
        System.out.println(abc.search("....e."));

    }
}
//["  "addWord","addWord","addWord","addWord","addWord","addWord","addWord","addWord","search","search","search","search","search","search","search","search","search","search"]
//[[],["ran"],["rune"],["runner"],["runs"],["add"],["adds"],["adder"],["addee"],  ["r.n"],["ru.n.e"],["add"],["add."],["adde."],[".an."],["...s"],["....e."],["......."],["..n.r"]]
//[null,null,null,null,null,null,null,null,null,true,false,true,true,true,false,true,false,false,false]
//[null,null,null,null,null,null,null,null,null,true,false,true,true,true,false,true,true,false,false]