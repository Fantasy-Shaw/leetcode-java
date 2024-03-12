package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution84 {
    static class Solution {
        public int largestRectangleArea(int[] heights) {
            int n = heights.length;
            if (heights.length == 1) {
                return heights[0];
            }
            int[] left = new int[n], right = new int[n];
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                left[i] = st.isEmpty() ? -1 : st.peek();
                st.push(i);
            }
            st.clear();
            for (int i = n - 1; i >= 0; i--) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                    st.pop();
                }
                right[i] = st.isEmpty() ? n : st.peek();
                st.push(i);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int d = right[i] - left[i] - 1;
                ans = Math.max(ans, heights[i] * d);
            }
            return ans;
        }
    }
}