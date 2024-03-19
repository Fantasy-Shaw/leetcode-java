package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1793 {
    class Solution {
        public int maximumScore(int[] nums, int k) {
            int n = nums.length;
            if (nums.length == 1) {
                return nums[0];
            }
            int[] left = new int[n], right = new int[n];
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }
                left[i] = st.isEmpty() ? 0 : st.peek() + 1;
                st.push(i);
            }
            st.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                    st.pop();
                }
                right[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
                st.push(i);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (left[i] <= k && k <= right[i]) {
                    int d = right[i] - left[i] + 1;
                    ans = Math.max(ans, nums[i] * d);
                }
            }
            return ans;
        }
    }
}