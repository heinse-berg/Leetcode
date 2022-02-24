package com.leetcodecards.recursion2;

import java.util.*;

public class MyMergeSort {

    public void merge(int l, int r, int[] arr) {

        if(l < r) {
            int mid = l + (r - l) / 2;
            merge(l, mid, arr);
            merge(mid + 1, r, arr);

            combine(l, r, mid, arr);
        }

    }

    public void combine(int l, int r, int mid, int[] arr) {
        int[] temp = new int[r-l+1];
        int i = l, j = mid+1, k = 0;

        while(i <= mid && j <= r)
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];

        while(i <= mid)
            temp[k++] = arr[i++];
        while(j <= r)
            temp[k++] = arr[j++];

        for(i = l, k = 0; i <= r; i++,k++)
            arr[i] = temp[k];
    }

    public void mergeSort(int[] arr) {
        merge(0, arr.length-1, arr);
    }

    public static void main(String[] args) {
        MyMergeSort abc = new MyMergeSort();
        /*int[] a = new int[] {11,10,5,4,3,1,2,7,-1,2,-100,7};*/
        int[] a = new int[]{9,6};
        abc.mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
}
