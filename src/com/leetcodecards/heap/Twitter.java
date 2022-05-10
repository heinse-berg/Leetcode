package com.leetcodecards.heap;

import java.util.*;

public class Twitter {

    HashMap<Integer, HashSet<Integer>> followers;
    LinkedList<int[]> lru;

    public Twitter() {
        followers = new HashMap<>();
        lru = new LinkedList<>();
    }

    public void postTweet(int userId, int tweetId) {
        lru.addFirst(new int[] {userId, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> newsFeed = new LinkedList<>();
        HashSet<Integer> followers = this.followers.get(userId);

        for(int[] arr : lru) {
            if(arr[0] == userId || followers.contains(arr[0]))
                newsFeed.addLast(arr[1]);
        }

        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        followers.get(followerId).remove(followeeId);
    }

    public static void main(String[] args) {

    }
}
