package com.algorithm.searchsort;

public class GuessNo {

    int guess(int num) {
        return 1;
    }

    public int guessNumber(int n) {
        int low = 1, high = n, mid;
        while(low <= high) {
            mid = low + (high-low)/2;
            if(guess(mid) == 0)
                return mid;
            else if(guess(mid) == -1)
                high = mid-1;
            else
                low = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        GuessNo abc = new GuessNo();
        abc.guessNumber(30);
        System.out.println();
    }
}
