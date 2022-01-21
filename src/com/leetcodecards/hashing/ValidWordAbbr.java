package com.leetcodecards.hashing;

import java.util.*;
import java.util.function.BiFunction;

public class ValidWordAbbr {
    HashMap<String, HashSet<String>> map = new HashMap<>();
    BiFunction<HashSet<String>, HashSet<String>, HashSet<String>> remappingFunction = (oldVal, newVal) ->  {
        oldVal.addAll(newVal);
        return oldVal;
    };

    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary) {
            int len = s.length();
            if(len <= 2)
                map.merge(s, new HashSet<>(Collections.singletonList(s)), remappingFunction);
            else {
                StringBuilder sb = new StringBuilder().append(s.charAt(0)).append(len-2).append(s.charAt(len-1));
                map.merge(sb.toString(), new HashSet<>(Arrays.asList(s)), remappingFunction);
            }
        }
    }

    public boolean isUnique(String word) {
        int length = word.length();
        String abbrev = length <= 2 ?  word:
                new StringBuilder().append(word.charAt(0)).append(length-2).append(word.charAt(length-1)).toString();
        if(!map.containsKey(abbrev))
            return true;
        HashSet<String> st = (map.get(abbrev));
        return st.size() == 1 && st.contains(word);
    }

    public static void main(String[] args) {
        ValidWordAbbr abc = new ValidWordAbbr(new String[]{"deer", "door", "cake", "card"});
        System.out.println(abc.isUnique("cake"));
        System.out.println(abc.isUnique("door"));
        System.out.println(abc.isUnique("cane"));
    }
}
