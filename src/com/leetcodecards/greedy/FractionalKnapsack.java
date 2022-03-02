package com.leetcodecards.greedy;

import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

public class FractionalKnapsack {

    double fractionalKnapsack(int W, Item[] arr, int n) {
        int curWeight = 0; // Current weight in knapsack
        double finalvalue = 0.0; // Result (value in Knapsack)

        // Looping through all Items
        for (int i = 0; i < n; i++) {
            // If adding Item won't overflow, add it completely
            if (curWeight + arr[i].weight <= W) {
                curWeight += arr[i].weight;
                finalvalue += arr[i].value;
            }

            // If we can't add current Item, add fractional part
            // of it
            else {
                int remain = W - curWeight;
                finalvalue += arr[i].value * ((double)remain / (double)arr[i].weight);
                break;
            }
        }

        // Returning final value
        return finalvalue;
    }

    public static void main(String[] args) {
        FractionalKnapsack abc = new FractionalKnapsack();
        System.out.println(abc.fractionalKnapsack(7, new Item[]{new Item(60,10),
                new Item(100, 20), new Item(120,30)}, 3));
    }
}
