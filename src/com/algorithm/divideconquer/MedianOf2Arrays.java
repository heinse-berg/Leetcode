package com.algorithm.divideconquer;

import java.util.Arrays;

public class MedianOf2Arrays {

    static int[] merge(int[]arr1, int []arr2) {
        int i = 0, j = 0, k = 0;
        int[] result = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                result[k++] = arr1[i];
                i++;
            }
            else {
                result[k++] = arr2[j];
                j++;
            }
        }
        if(i == arr1.length)
            while(j < arr2.length)
                result[k++] = arr2[j++];
        else
            while(i < arr1.length)
                result[k++] = arr1[i++];
        return result;
    }

    static int power(int x, int y)
    {
        int temp;
        if( y == 0)
            return 1;
        temp = power(x, y / 2);
        if (y % 2 == 0) {
            System.out.printf("x = %d , y = %d, ans = %d * %d", x , y , temp, temp);
            System.out.println();
            return temp * temp;
        }
        else {
            System.out.printf("x = %d , y = %d, ans = %d * %d * %d", x , y , x,temp, temp);
            System.out.println();
            return x * temp * temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30, 40};
        int[] arr2 = {11, 22, 33, 44, 55, 66};
        boolean[] a = new boolean[3];
        System.out.println(Arrays.toString(merge(arr1, arr2)));
        System.out.println(power(6, 9));
        System.out.println(Arrays.toString(a));
    }
}
