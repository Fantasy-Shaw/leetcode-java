package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2736 {
    class Solution {
        public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
            int n = nums1.length;
            // int[2], int[3]
            List<int[]> sortedNums = new ArrayList<>(), sortedQueries = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                sortedNums.add(new int[]{nums1[i], nums2[i]});
            }
            sortedNums.sort((a, b) -> b[0] == a[0] ? b[1] - a[1] : b[0] - a[0]);
            for (int i = 0; i < queries.length; i++) {
                sortedQueries.add(new int[]{i, queries[i][0], queries[i][1]});
            }
            sortedQueries.sort((a, b) -> b[1] - a[1]);
            int[] ans = new int[queries.length];
            Arrays.fill(ans, -1);
            List<int[]> stack = new ArrayList<>();
            int j = 0;
            for (int[] q : sortedQueries) {
                int i = q[0], x = q[1], y = q[2];
                while (j < n && sortedNums.get(j)[0] >= x) {
                    int n1 = sortedNums.get(j)[0], n2 = sortedNums.get(j)[1];
                    while (!stack.isEmpty() && stack.getLast()[1] < (n1 + n2)) {
                        stack.removeLast();
                    }
                    if (stack.isEmpty() || stack.getLast()[0] < n2) {
                        stack.add(new int[]{n2, n1 + n2});
                    }
                    j++;
                }
                int k = lowerBound(stack, y);
                if (k < stack.size()) {
                    ans[i] = stack.get(k)[1];
                }
            }
            return ans;
        }

        private int lowerBound(List<int[]> st, int target) {
            int left = -1, right = st.size();
            while (left + 1 < right) {
                int mid = (left + right) / 2;
                if (st.get(mid)[0] >= target) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }
    }
}