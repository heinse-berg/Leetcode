package com.leetcodecards.arrays101;

import java.util.*;

public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int noZeros = 0, len = arr.length, i = 0, j = 0, k;
        while(i < len) {
            if(arr[i] == 0) noZeros++;
            i++;
        }
        for(i = 0; i < noZeros; i++) {
            for(; j < len; j++) if(arr[j] == 0) break;
            for(k = len-1; k > j; k--) arr[k] = arr[k-1];
            j = j+2;
        }
    }

    public static void main(String[] args) {
        DuplicateZeros abc = new DuplicateZeros();
        abc.duplicateZeros(new int[] {1,0,2,3,0,4,5,0,6,7,8,9,20});
        System.out.println();
    }
}
