package com.leetcodecards.graph.bfs;

import java.util.*;

public class WordLadder {
    int n;

    boolean canConnect(String si, String sj) {
        int diff = 0;
        for(int i = 0; i < n; i++) {
            if (si.charAt(i) != sj.charAt(i))
                diff++;
            if(diff == 2)
                return false;
        }
        return diff < 2;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, HashSet<String>> graph = new HashMap<>();
        wordList.add(beginWord);
        int m = wordList.size(), ans = 0; n = beginWord.length();
        HashSet<String> visited = new HashSet<>();

        for(int i = 0; i < m; i++) {
            String si = wordList.get(i);
            for (int j = i + 1; j < m; j++) {
                String sj = wordList.get(j);
                if(canConnect(si, sj)) {
                    if (!graph.containsKey(si))
                        graph.put(si, new HashSet<>());
                    graph.get(si).add(sj);
                    if (!graph.containsKey(sj))
                        graph.put(sj, new HashSet<>());
                    graph.get(sj).add(si);
                }
            }
        }

        ArrayDeque<String> q = new ArrayDeque<>();
        q.addLast(beginWord);

        while(!q.isEmpty()) {
            int currSize = q.size();
            ans++;
            for(int i = 0; i < currSize; i++) {
                String curr = q.pollFirst();
                visited.add(curr);
                if(curr.equals(endWord))
                    return ans;
                for(String s : graph.get(curr)) {
                    if(!visited.contains(s))
                        q.add(s);
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder abc = new WordLadder();
        LinkedList<String> l = new LinkedList<>(Arrays.asList("hot", "dot", "dog", "dot", "log"));
        System.out.println(abc.ladderLength("hit", "cog", l));
    }
}
