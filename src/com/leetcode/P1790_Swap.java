package com.leetcode;

public class P1790_Swap {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        int i = 0, count = 0;
        char prevS1Mis = ' ', prevS2Mis = ' ';
        while(i < s1.length() && count < 3) {
            boolean b = s1.charAt(i) == s2.charAt(i);
            if(!b && count == 0) {
                prevS1Mis = s1.charAt(i);
                prevS2Mis = s2.charAt(i);
                count++;
            }
            else if(!b && count == 1) {
                if(prevS1Mis != s2.charAt(i) || prevS2Mis != s1.charAt(i))
                    break;
                count++;
            }
            else if(!b)
                count++;
            i++;
        }
        if(count == 2)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        //enter code"hphyrlaftwzdyscbrraxajeevycarzovuwxazqhrzjuxwqeoqwhwxgvxgfz"
        //"hhzxqgvwqpxrwcwfjuaquvhzcogexayjzrebahfsxdwreytraxzvlrwoyaz"
        //"qgqeg"
        //"gqgeq"
        System.out.println(new P1790_Swap().areAlmostEqual("qgqeg", "gqgeq"));
    }
}
