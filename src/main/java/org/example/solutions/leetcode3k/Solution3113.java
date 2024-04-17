package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3113 {
    class Solution {
        public long numberOfSubarrays(int[] nums) {
            Deque<int[]> st = new ArrayDeque<>();
            st.push(new int[]{Integer.MAX_VALUE, 0});
            long ans = 0;
            for (int x : nums) {
                while (x > st.peek()[0]) {
                    st.pop();
                }
                if (x == st.peek()[0]) {
                    ans += st.peek()[1];
                    st.peek()[1]++;
                } else {
                    st.push(new int[]{x, 1});
                }
            }
            ans += nums.length; // single elements
            return ans;
        }
    }
}