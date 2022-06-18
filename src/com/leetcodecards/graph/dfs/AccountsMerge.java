package com.leetcodecards.graph.dfs;

import javafx.util.Pair;

import java.util.*;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Pair<String, TreeSet<String>>> graph = new HashMap<>();

        for(List<String> list : accounts) {

            boolean flag = false;

            for(String s : list) {
                if(graph.containsKey(s)) {
                    list.remove(0);
                    graph.get(s).getValue().addAll(list);
                    flag = true;
                    break;
                }
            }

            if(!flag) {
                String name = list.remove(0);

                for(String s : list) {
                    graph.put(s, new Pair<>(name, new TreeSet<>(list)));
                }
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for(Map.Entry<String, Pair<String, TreeSet<String>>> entry : graph.entrySet()) {
            ans.add(new ArrayList<>());
            ans.get(ans.size() - 1).add(entry.getValue().getKey());
            ans.get(ans.size() - 1).addAll(entry.getValue().getValue());
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
