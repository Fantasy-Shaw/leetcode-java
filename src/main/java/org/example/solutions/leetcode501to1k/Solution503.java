package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution503 {
    class Solution {
        // Pre : Leetcode-496; Recurrent: double length
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            Arrays.fill(ans, -1);
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < n * 2 - 1; i++) {
                while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                    ans[stack.pop()] = nums[i % n];
                }
                stack.push(i % n);
            }
            return ans;
        }
    }
}