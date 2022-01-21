package com.leetcodecards.recursion2;

import java.util.*;

public class QuickSOrt {

    public void quickSort(int[] arr) {
        if(arr == null || arr.length == 0)
            return;
        qsort(arr, 0, arr.length);
    }

    public void qsort(int[] arr, int lo, int high) {
        if(lo < high) {
            int partition = partition(arr, lo, high);
            qsort(arr, lo, partition - 1);
            qsort(arr, partition + 1, high);
        }
    }

    int partition(int[] arr, int lo, int high) {
        int pivot = arr[high-1], j, tmp, i = lo;
        for(j = lo; j < high; j++) {
            if(arr[j] < pivot) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        tmp = arr[i];
        arr[i] = arr[high-1];
        arr[high-1] = tmp;
        return i;
    }

    public static void main(String[] args) {
        QuickSOrt abc = new QuickSOrt();
        int[] a = new int[] {1,3,4,2,5,-1,0,8,9};
        abc.quickSort(a);
        System.out.println(Arrays.toString(a));
    }
}
