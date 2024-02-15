package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1124 {
    class Solution {
        public int longestWPI(int[] hours) {
            int n = hours.length;
            int[] sum = new int[n + 1];
            int ans = 0;
            Deque<Integer> st = new ArrayDeque<>();
            st.push(sum[0]);
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + (hours[i] > 8 ? 1 : -1);
                if (sum[i + 1] < sum[st.peek()]) {
                    st.push(i + 1);
                }
            }
            for (int i = n; i >= 0; i--) {
                while (!st.isEmpty() && sum[i] > sum[st.peek()]) {
                    ans = Math.max(ans, i - st.pop());
                }
            }
            return ans;
        }
    }
}