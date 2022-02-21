package com.leetcodecards.greedy;

import java.util.*;

public class CurrGas {

    public int canCompleteCircuit(final int[] A, final int[] B) {
        int i, currGas, count, j, n = A.length;
        for(i = 0; i < n; i++) {
            currGas = 0; count = 0; j = i;
            while(count < n) {
                currGas += A[j];
                if(currGas < B[j])
                    break;
                currGas -= B[j];
                j = (j+1)%n;
                count++;
            }
            if(count == n)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        CurrGas abc = new CurrGas();
        System.out.println(abc.canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}));
    }
}
