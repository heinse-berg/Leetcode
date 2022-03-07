package com.leetcodecards.trie;

import java.util.*;

public class WordSearch {

    static class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean isWord = false;
    }

    static int[][] directions = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}};

    TrieNode root;
    int m, n;
    boolean[][] visited;

    public boolean dfs(int i, int j, TrieNode curr, char[][] board) {

        if(curr.isWord)
            return true;

        visited[i][j] = true;

        for(int[] d : directions) {
            int newX = d[0] + i;
            int newY = d[1] + j;
            if(newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY] && curr.map.containsKey(board[newX][newY]))
                if(dfs(newX, newY, curr.map.get(board[newX][newY]), board))
                    return true;
        }

        visited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        root = new TrieNode();
        TrieNode curr = root;
        m = board.length; n = board[0].length;

        for(char c : word.toCharArray()) {
            if(!curr.map.containsKey(c))
                curr.map.put(c, new TrieNode());
            curr = curr.map.get(c);
        }
        curr.isWord = true;

        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                visited = new boolean[m][n];
                curr = root;
                if(curr.map.containsKey(board[i][j]) && dfs(i, j, curr.map.get(board[i][j]), board))
                    return true;
            }

        return false;
    }

    public static void main(String[] args) {
        WordSearch abc = new WordSearch();
        System.out.println(abc.exist(new char[][]
                        {{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}
                , "ABCEFSADEESE"));
    }
    //[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]]
    //"ABCEFSADEESE"
}
