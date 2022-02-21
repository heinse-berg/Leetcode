package com.leetcodecards.hashing;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new LinkedList<>();
        HashMap<Integer, LinkedList<String>> map = new HashMap<>();

        for (String s : strs) {
            int hash = 0;

            for(char c : s.toCharArray())
                hash += c-100;

            if(!map.containsKey(hash))
                map.put(hash, new LinkedList<>());
            map.get(hash).add(s);
        }

        for(LinkedList<String> set :  map.values())
            ans.add(new LinkedList<>(set));

        return ans;
    }

    public static void main(String[] args) {
        GroupAnagrams abc = new GroupAnagrams();
        System.out.println(abc.groupAnagrams(new String[]{"bd", "bdd"}));
    }
}
