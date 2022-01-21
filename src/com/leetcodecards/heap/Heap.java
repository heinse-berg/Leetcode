package com.leetcodecards.heap;

import java.util.*;

public class Heap {
    int[] array;
    int currSize;

    public Heap(int initialSize) {
        array = new int[initialSize];
        currSize = 0;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void add(int num) {
        //not checking capacity
        array[currSize++] = num;
        if(currSize == 0)
            return;
        int i = currSize-1, j = (i % 2 == 0) ? (i-2)/2 : (i-1)/2 ;
        while(j >= 0 && array[i] < array[j]) {
            swap(i, j);
            i = j;
            j = (j % 2 == 0) ? (j-2)/2 : (j-1)/2;
        }
    }

    public int getTop() {
        return array[0];
    }

    public void delete() {
        //not checking capacity
        array[0] = array[--currSize];
        if(currSize == 0 || currSize == 1 || (currSize == 2 && array[0] < array[1]))
            return;
        if(currSize == 2) {
            swap(0,  currSize-1);
            return;
        }
        int i = 0, childLeft=1, childRight=2;
        while(childLeft < currSize) {
            if(childRight >= currSize || array[childLeft] < array[childRight]) {
                swap(i, childLeft);
                i = childLeft;
            }
            else {
                swap(i, childRight);
                i = childRight;
            }
            childLeft = i*2 + 1;
            childRight = i*2 + 2;
        }
    }

    public static void main(String[] args) {
        Heap abc = new Heap(15);
        for(int i = 11; i <= 17; i++) {
            abc.add(i);
        }
        abc.add(10);
        abc.add(9);
        abc.add(7);
        abc.add(-1);
        abc.add(20);

        System.out.println(Arrays.toString(abc.array));

        for(int i = 0; i < 12; i++) {
            abc.delete();
            System.out.println("Currsize " + abc.currSize + " "  + "Min " + abc.getTop() + " " + Arrays.toString(abc.array));
        }

        System.out.println(Arrays.toString(abc.array));
    }
}
