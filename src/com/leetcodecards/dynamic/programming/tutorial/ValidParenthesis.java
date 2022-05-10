package com.leetcodecards.dynamic.programming.tutorial;

import java.util.*;

public class ValidParenthesis {
    boolean[] memo;

    public boolean dp(StringBuilder s, int i, int open) {

        if(i == s.length())
            return open == 0;

        char c = s.charAt(i);
        if(c == '(') {
            return dp(s, i+1, ++open);
        }

        else if(c == ')') {
            return open != 0 && dp(s, i + 1, --open);
        }

        else {
            s.setCharAt(i, ')');
            int temp = open;
            if(open != 0 && dp(s, i+1, --open))
                return true;
            open = temp;

            s.setCharAt(i, '(');
            if(dp(s, i+1, ++open))
                return true;

            return dp(s, i + 1, open);
        }
    }

    public boolean checkValidString(String s) {
        return dp(new StringBuilder(s), 0, 0);
    }

    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        System.out.println(vp.checkValidString("(((*"));
    }
}
