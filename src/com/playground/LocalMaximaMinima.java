package com.playground;

import java.util.*;

public class LocalMaximaMinima {

    public List<Integer> maxima(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        int i, len = arr.length, j;
        if(arr[0] >= arr[1])
            list.add(arr[0]);
        for(i = 0; i < len; i++) {
            j = i;
            while((j+1) < len && (arr[j] <= arr[j+1])) j++;
            if(i != j) {
                list.add(arr[j]);
                i = j;
            }
        }
        return list;
    }

    public List<Integer> minima(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        int i, len = arr.length, j;
        if(arr[0] <= arr[1])
            list.add(arr[0]);
        for(i = 0; i < len; i++) {
            j = i;
            while((j+1) < len && (arr[j] >= arr[j+1])) j++;
            if(i != j) {
                list.add(arr[j]);
                i = j;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LocalMaximaMinima abc = new LocalMaximaMinima();
        System.out.println(abc.minima(new int[] {5,4,3,2,1,2,0,1,2,3,4,5,3,2,1,3,4}));
        System.out.println(abc.minima(new int[] {1,2,3,4,5,2,0,6}));
        System.out.println(abc.minima(new int[] {1,2,3,4,5,2,0,6}));
        System.out.println(abc.minima(new int[] {1,2,3,4,5,5,5,5,5,2,0,6,7,8,91,0,-1,-2,-3}));
        System.out.println("maxima:");
        System.out.println(abc.maxima(new int[] {5,4,3,2,1,2,0,1,2,3,4,5,3,2,1,3,4,55}));
        System.out.println(abc.maxima(new int[] {1,2,3,4,5,2,0,6}));
        System.out.println(abc.maxima(new int[] {1,2,3,4,5,2,0,6}));
        System.out.println(abc.maxima(new int[] {1,2,3,4,5,5,5,5,5,2,0,6,7,8,91,0,-1}));
    }
}
