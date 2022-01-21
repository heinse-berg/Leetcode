package com.playground;

import java.util.PriorityQueue;
import java.util.regex.*;

public class StringManip {

    public static void main(String[] args) {
        //enter code
        //System.out.println(new StringManip().func());
        StringBuilder string = new StringBuilder("1234abcd");
        Pattern pattern = Pattern.compile("abc");
        Matcher matcher = pattern.matcher(string.toString());
        while(matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
        }
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("");
        pq.poll();
        pq.remove("");
    }
}
