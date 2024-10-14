package org.example.solutions.leetcode3k;

import java.util.TreeSet;

public class Solution3080 {
    class Solution {
        public long[] unmarkedSumArray(int[] nums, int[][] queries) {
            long sum = 0;
            for (int i : nums) {
                sum += i;
            }
            TreeSet<int[]> set = new TreeSet<>(
                    (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]
            );
            for (int i = 0; i < nums.length; i++) {
                set.add(new int[]{i, nums[i]});
            }
            long[] ans = new long[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int idx = queries[i][0], k = queries[i][1];
                int[] idx_n = new int[]{idx, nums[idx]};
                if (set.contains(idx_n)) {
                    sum -= nums[idx];
                    set.remove(idx_n);
                }
                while (!set.isEmpty() && k > 0) {
                    var p = set.pollFirst();
                    sum -= p[1];
                    k--;
                }
                ans[i] = sum;
            }
            return ans;
        }
    }
}