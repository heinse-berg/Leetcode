package com.playground;

import java.util.*;

public class BinRep {

    public int binRep(int num) {
        int pow = 1, rem = 0;

        while(num > 0) {
            rem += (num % 2) * pow;
            num /= 2;
            pow *= 10;
        }
        return rem;
    }

    public static void main(String[] args) {
        BinRep abc = new BinRep();
        for(int i = 0; i < 20; i++)
            System.out.println(abc.binRep(i));
    }
}
