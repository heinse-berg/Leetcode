package com.gfg;

import java.util.*;

//https://practice.geeksforgeeks.org/problems/in-first-but-second5423/1
public class MissingSecondArray {
    ArrayList<Long> findMissing(long A[], long B[], int N, int M) {
        ArrayList<Long> result = new ArrayList<>();
        HashSet<Long> set = new HashSet<>(M);
        Arrays.stream(B).forEach(set::add);
        for(int i=0; i < N; i++)
            if(!set.contains(A[i]))
                result.add(A[i]);
        return result;
    }

    public static void main(String[] args) {
        MissingSecondArray abc = new MissingSecondArray();
        long[] A = {227, 2, 17, 15, 17, 21, 26, 30, 16, 12, 19, 22, 18, 8, 24, 10, 17, 28, 14, 7, 4, 21, 3, 4};
        long[] B = {25, 12, 30, 24, 14, 34};
        System.out.println(abc.findMissing(A, B, 24, 6));
    }
}
