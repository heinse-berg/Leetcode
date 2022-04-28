package com.leetcodecards.trie;

import java.util.*;

public class WordSearchII {
    int[][] directions = new int[][] { {0,1}, {1,0}, {-1,0}, {0,-1} };
    int m, n;
    LinkedList<String> res = new LinkedList<>();

    static class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {

        TrieNode root = new TrieNode(), curr;
        m = board.length; n = board[0].length;

        for(String word : words) {
            curr = root;
            for(char c : word.toCharArray()) {
                if(!curr.map.containsKey(c))
                    curr.map.put(c, new TrieNode());
                curr = curr.map.get(c);
            }
            curr.word = word;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                curr = root;
                if(curr.map.containsKey(board[i][j]))
                    dfs(i, j, board, curr);
            }
        }

        return res;
    }

    public void dfs(int i, int j, char[][] board, TrieNode currNode) {
        char letter = board[i][j];

        TrieNode curr = currNode.map.get(letter);

        if(curr.word != null) {
            res.addLast(curr.word);
        }

        board[i][j] = '.';

        for(int[] d : directions) {
            int x = d[0] + i, y = d[1] + j;
            if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] != '.' && curr.map.containsKey(board[x][y]))
                dfs(x, y, board, curr);
        }

        board[i][j] = letter;
    }

    public static void main(String[] args) {
        WordSearchII abc = new WordSearchII();
        System.out.println();
    }
}
