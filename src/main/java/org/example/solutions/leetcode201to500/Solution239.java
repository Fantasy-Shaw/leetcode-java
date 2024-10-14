package org.example.solutions.leetcode201to500;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Solution239 {
    class Solution1 {
        //PriorityQueue O(NlogN)
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p2[0] == p1[0] ? p2[1] - p1[1] : p2[0] - p1[0]);
            for (int i = 0; i < k; i++) {
                pq.offer(new int[]{nums[i], i});
            }
            ans[0] = pq.peek()[0];
            for (int i = k; i < n; i++) {
                pq.offer(new int[]{nums[i], i});
                while (pq.peek()[1] <= i - k) pq.poll();
                ans[i - k + 1] = pq.peek()[0];
            }
            return ans;
        }
    }

    class Solution {
        //MonoQueue O(N) (Impl with deque)
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[n - k + 1];
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) deque.pollLast();
                deque.offerLast(i);
            }
            ans[0] = nums[deque.peekFirst()];
            for (int i = k; i < n; i++) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                while (deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
            return ans;
        }
    }
}