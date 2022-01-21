package com.leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/invalid-transactions/
public class P1169_InvalidTransaction {

    public List<String> invalidTransactions(String[] transactions) {
        boolean[] valid = new boolean[transactions.length];
        String[][] strings = new String[transactions.length][4];
        int i = 0;
        for(String s: transactions) {
            strings[i++] = s.split(",");
        }
        for(i = 0; i < transactions.length; i++)
            valid[i] = true;
        for(i = 0; i < transactions.length; i++)
            if(Integer.parseInt(strings[i][2]) > 1000)
                valid[i] = false;
        for(i = 0; i < transactions.length; i++) {
            if(valid[i]) {
                for (int j = 0; j < transactions.length ; j++) {
                    if(j != i)
                        if(strings[i][0].equals(strings[j][0]) && !(strings[i][3].equals(strings[j][3])) &&
                                        Math.abs(Integer.parseInt(strings[i][1]) - Integer.parseInt(strings[j][1])) <= 60)
                            valid[i] = false;
                }
            }
        }
        List<String> ans = new ArrayList<>();
        for(i = 0; i < transactions.length; i++) {
            if(!valid[i])
                ans.add(transactions[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] strings = {"alex,676,260,bangkok","bob,656,1366,bangkok","alex,393,616,bangkok","bob,820,990,amsterdam","alex,596,1390,amsterdam"};

        System.out.println(new P1169_InvalidTransaction().invalidTransactions(strings));
    }

}
