package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution355 {
    class Twitter {
        // Leetcode-23 : Merge k sorted lists
        Map<Integer, Set<Integer>> followers;
        Map<Integer, TweetNode> userTweets;
        int time;

        public Twitter() {
            followers = new HashMap<>();
            userTweets = new HashMap<>();
            time = 0;
        }

        public void postTweet(int userId, int tweetId) {
            time++;
            TweetNode latest = userTweets.getOrDefault(userId, null);
            TweetNode cur = new TweetNode(tweetId, time, latest);
            userTweets.put(userId, cur);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> ans = new ArrayList<>();
            PriorityQueue<TweetNode> pq = new PriorityQueue<>(Comparator.comparingInt(value -> -value.time));
            // My tweets
            if (userTweets.containsKey(userId)) {
                pq.offer(userTweets.get(userId));
            }
            // My followers' tweets
            if (followers.containsKey(userId)) {
                for (int fo : followers.get(userId)) {
                    if (userTweets.containsKey(fo)) {
                        pq.offer(userTweets.get(fo));
                    }
                }
            }
            while (!pq.isEmpty() && ans.size() < 10) {
                TweetNode tw = pq.poll();
                ans.add(tw.tweetId);
                if (tw.next != null) {
                    pq.offer(tw.next);
                }
            }
            return ans;
        }

        public void follow(int followerId, int followeeId) {
            followers.putIfAbsent(followerId, new HashSet<>());
            followers.get(followerId).add(followeeId);
        }

        public void unfollow(int followerId, int followeeId) {
            followers.putIfAbsent(followerId, new HashSet<>());
            followers.get(followerId).remove(followeeId);
        }

        static class TweetNode {
            public int time;
            public int tweetId;
            public TweetNode next;

            public TweetNode(int tweetId, int time, TweetNode next) {
                this.tweetId = tweetId;
                this.time = time;
                this.next = next;
            }
        }
    }

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
}