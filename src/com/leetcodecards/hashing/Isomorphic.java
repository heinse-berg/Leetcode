package com.leetcodecards.hashing;

import java.util.*;

public class Isomorphic {

    public boolean isIsomorphic(String s, String t) {
        if(s.equals(t)) return true;
        HashMap<Character, Character> map = new HashMap<>();
        int i, sl = s.length();
        char sc, st;
        for(i = 0; i < sl; i++) {
            sc = s.charAt(i); st = t.charAt(i);
            if(!map.containsKey(sc)) {
                if(!map.containsValue(st))
                    map.put(sc, st);
                else {
                    return false;
                }
            }
            else if(map.get(sc) != st)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Isomorphic abc = new Isomorphic();
        System.out.println(abc.isIsomorphic("badc", "baba"));
        System.out.println(abc.isIsomorphic("paper", "title"));
        System.out.println(abc.isIsomorphic("acbb", "brbb"));
        //"bbbaaaba"
        //"aaabbbba"
    }
}
