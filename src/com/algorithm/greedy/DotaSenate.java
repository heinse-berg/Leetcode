package com.algorithm.greedy;

//https://leetcode.com/problems/dota2-senate/
public class DotaSenate {

    public String predictPartyVictory(String senate) {
        StringBuilder s = new StringBuilder(senate);
        String RADIANT = "Radiant", DIRE = "Dire";
        int i, j;
        while(true) {
            j = 0;
            if (s.charAt(j) == 'R' && s.indexOf("D") < 0)
                return RADIANT;
            else if (s.charAt(j) == 'D' && s.indexOf("R") < 0)
                return DIRE;
            i = 0;
            while (i < s.length()) {
                int index;
                if (s.charAt(i) == 'R') {
                    index= s.indexOf("D", i+1);
                    if(index < 0)
                        index = s.indexOf("D", 0);
                } else {
                    index = s.indexOf("R", i+1);
                    if(index < 0)
                        index = s.indexOf("R", 0);
                }
                if(index < 0)
                    break;
                s.deleteCharAt(index);
                if(index > i)
                    i++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new DotaSenate().predictPartyVictory("DRRDRDRDRDDRDRDR"));
    }
}
