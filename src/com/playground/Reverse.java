package com.playground;

import java.util.*;

public class Reverse {

    int reverse(int num) {
        int rev = 0;
        while(num > 0) {
            rev = rev * 10 + (num%10);
            num /= 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        Reverse abc = new Reverse();
        System.out.println(abc.reverse(456789));
        System.out.println(abc.reverse(1234567));
        System.out.println(abc.reverse(4567));
        System.out.println(abc.reverse(4567000));
        System.out.println(abc.reverse(4567890));
        System.out.println(abc.reverse(456780));
    }
}
