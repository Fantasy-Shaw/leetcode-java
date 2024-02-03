package org.example.solutions.LCP;

import java.util.*;

public class P24 {
    class Solution {
        final int mod = (int) 1e9 + 7;

        public int[] numsGame(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            // Leetcode-295 对顶堆动态维护中位数
            PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 左边是大顶堆
            PriorityQueue<Integer> right = new PriorityQueue<>(); // 右边是小顶堆
            long lSum = 0, rSum = 0;
            for (int i = 0; i < n; i++) {
                int b = nums[i] - i;
                if (i % 2 == 0) {
                    if (!left.isEmpty() && b < left.peek()) {
                        lSum -= (left.peek() - b);
                        left.offer(b);
                        b = left.poll();
                    }
                    rSum += b;
                    right.offer(b);
                    ans[i] = (int) ((rSum - right.peek() - lSum) % mod);
                } else {
                    if (b > right.peek()) {
                        rSum += (b - right.peek());
                        right.offer(b);
                        b = right.poll();
                    }
                    lSum += b;
                    left.offer(b);
                    ans[i] = (int) ((rSum - lSum) % mod);
                }
            }
            return ans;
        }
    }
}