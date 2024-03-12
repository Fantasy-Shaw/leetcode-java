package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution739 {
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int n = temperatures.length;
            int[] ans = new int[n];
            Deque<Integer> st = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                    int pre = st.pop();
                    ans[pre] = i - pre;
                }
                st.push(i);
            }
            return ans;
        }
    }
}