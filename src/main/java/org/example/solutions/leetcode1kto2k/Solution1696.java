package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1696 {
    class Solution {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            Deque<Integer> qu = new ArrayDeque<>();
            qu.add(0);
            for (int i = 1; i < n; i++) {
                if (qu.peekFirst() < i - k) {
                    qu.pollFirst();
                }
                dp[i] = dp[qu.peekFirst()] + nums[i];
                while (!qu.isEmpty() && dp[i] >= dp[qu.peekLast()]) {
                    qu.pollLast();
                }
                qu.add(i);
            }
            return dp[n - 1];
        }
    }

    class Solution2 {
        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
            map.put(dp[0], 1);
            for (int i = 1; i < n; i++) {
                if (i - k > 0) {
                    int freq = map.get(dp[i - k - 1]);
                    if (freq == 1) {
                        map.remove(dp[i - k - 1]);
                    } else {
                        map.put(dp[i - k - 1], freq - 1);
                    }
                }
                int curMx = map.firstKey();
                dp[i] = curMx + nums[i];
                map.put(dp[i], map.getOrDefault(dp[i], 0) + 1);
            }
            return dp[n - 1];
        }
    }

    class Solution1 {
        public int maxResult(int[] nums, int k) {
            // Use dynamic programming, O(nk), TLE
            int n = nums.length;
            int[] dp = new int[n];
            dp[0] = nums[0];
            for (int i = 1; i < n; i++) {
                int curMx = Integer.MIN_VALUE;
                for (int j = Math.max(i - k, 0); j < i; j++) {
                    curMx = Math.max(dp[j], curMx);
                }
                dp[i] = curMx + nums[i];
            }
            return dp[n - 1];
        }
    }
}