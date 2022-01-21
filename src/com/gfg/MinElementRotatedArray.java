package com.gfg;

public class MinElementRotatedArray {
    int minElement(int[] arr, int low, int high) {
        //enter code
        if(arr[low] <= arr[high])
            return arr[low];
        int mid = (low + high) / 2;
        if((low < mid) && (arr[mid-1] > arr[mid]))
            return arr[mid];
        if(high > mid && (arr[mid+1] < arr[mid]))
            return arr[mid+1];
        if(arr[low] > arr[mid])
            return minElement(arr, low, mid-1);
        return minElement(arr, mid+1, high);
    }

    public static void main(String[] args) {
        MinElementRotatedArray abc = new MinElementRotatedArray();
        int[] array = new int[] {1, 4, 5, 6, 7, 8};
        System.out.println(abc.minElement(array, 0, array.length-1));
    }
}
