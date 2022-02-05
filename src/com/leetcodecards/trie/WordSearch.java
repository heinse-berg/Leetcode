package com.leetcodecards.trie;

import java.util.*;

public class WordSearch {

    static class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
    }

    public void insertTrieNode(String word) {
        if(set.contains(word))
            return;
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.map.containsKey(c)) {
                curr.map.put(c, new TrieNode());
            }
            curr = curr.map.get(c);
        }
        set.add(word);
    }

    int[][] directions = new int[][] { {0,-1}, {-1,0}, {0,1}, {1,0} };
    int rows, cols;
    boolean[][] visited;
    char[][] board;
    TrieNode root;
    HashSet<String> set = new HashSet<>();

    List<int[]> getNeighbors(int[] cell) {
        List<int[]> neighbors = new LinkedList<>();
        int x = cell[0];
        int y = cell[1];
        for(int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY]) {
                neighbors.add( new int[] {newX, newY} );
            }
        }
        return neighbors;
    }

    public void dfs(int[] cell, StringBuilder sb) {
        visited[cell[0]][cell[1]] = true;
        for(int[] neighbor : getNeighbors(cell)) {
            int neighX = neighbor[0]; int neighY = neighbor[1];
            if(!visited[neighX][neighY]) {
                insertTrieNode(sb.append(board[neighX][neighY]).toString());
                dfs(neighbor, sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        visited[cell[0]][cell[1]] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        rows = board.length; cols = board[0].length;
        visited  = new boolean[rows][cols]; this.board = board;
        List<String> ans = new LinkedList<>();
        int i;
        root = new TrieNode();

        for(int k = 0; k < rows; k++) {
            for (int l = 0; l < cols; l++) {
                insertTrieNode(String.valueOf(board[k][l]));
                dfs(new int[]{k, l}, new StringBuilder().append(board[k][l]));
            }

        }

        for(String word : words) {
            TrieNode curr = root;
            for(i = 0; i < word.length(); i++) {
                if(!curr.map.containsKey(word.charAt(i)))
                    break;
                curr = curr.map.get(word.charAt(i));
            }
            if(i == word.length())
                ans.add(word);
        }

        return ans;
    }

    public static void main(String[] args) {
        WordSearch abc = new WordSearch();
        /*System.out.println(abc.findWords(
                new char[][]   {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]  {"oath", "eat", "oathfi", "oataklv", "oaaaab", "ak"}));*/
        System.out.println(abc.findWords(new char[][] {{'a'}}, new String[]{"a"}));
    }
}
