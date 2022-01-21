package com.leetcodecards.hashing;

import javafx.util.Pair;

import java.util.*;

public class ShiftedStrings {

    boolean isShifted(String a , String b) {
        if(a.length() != b.length()) return false;
        int i, len = a.length(), diff = a.charAt(0)-b.charAt(0);
        for(i = 1; i < len; i++)
            if(a.charAt(i)-b.charAt(i) != diff) return false;
        return true;
    }
    char shiftLetter(char letter, int shift) {
        return (char) ((letter - shift + 26) % 26 + 'a');
    }

    // Create a hash value
    String getHash(String s) {
        char[] chars = s.toCharArray();

        // Calculate the number of shifts to make the first character to be 'a'
        int shift = chars[0];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = shiftLetter(chars[i], shift);
        }

        return String.valueOf(chars);
    }

    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> mapHashToList = new HashMap<>();

        // Create a hash_value (hashKey) for each string and append the string
        // to the list of hash values i.e. mapHashToList["abc"] = ["abc", "bcd"]
        for (String str : strings) {
            String hashKey = getHash(str);
            mapHashToList.computeIfAbsent(hashKey, k -> new ArrayList<>());
            mapHashToList.get(hashKey).add(str);
        }

        // Iterate over the map, and add the values to groups
        return new ArrayList<>(mapHashToList.values());
    }

    public static void main(String[] args) {
        ShiftedStrings abc = new ShiftedStrings();
        System.out.println(abc.isShifted("abc", "xyz"));
        System.out.println(abc.isShifted("wyz", "acd"));
        System.out.println(abc.isShifted("abc", "wyz"));
        System.out.println(abc.groupStrings(new String[]{"xyz","bcd","acef","xyz","az","ba","a","z"}));
    }
}
