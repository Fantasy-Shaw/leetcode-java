package org.example.solutions.leetcode501to1k;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution862 {
    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            int n = nums.length;
            long[] sum = new long[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
            Deque<Integer> qu = new ArrayDeque<>();
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i <= n; i++) {
                long cur = sum[i];
                while (!qu.isEmpty() && cur - sum[qu.peekFirst()] >= k) {
                    ans = Math.min(ans, i - qu.pollFirst());
                }
                while (!qu.isEmpty() && cur <= sum[qu.peekLast()]) {
                    qu.pollLast();
                }
                qu.addLast(i);
            }
            return ans <= n ? ans : -1;
        }
    }
}