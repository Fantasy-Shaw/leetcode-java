package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1944 {
    class Solution {
        public int[] canSeePersonsCount(int[] heights) {
            int n = heights.length;
            int[] ans = new int[n];
            Deque<Integer> monoSt = new ArrayDeque<>();
            for (int i = n - 1; i >= 0; i--) {
                while (!monoSt.isEmpty() && monoSt.peek() < heights[i]) {
                    monoSt.pop();
                    ans[i]++;
                }
                if (!monoSt.isEmpty()) {
                    ans[i]++;
                }
                monoSt.push(heights[i]);
            }
            return ans;
        }
    }
}