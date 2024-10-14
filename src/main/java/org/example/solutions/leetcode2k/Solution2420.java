package org.example.solutions.leetcode2k;

import java.util.ArrayList;
import java.util.List;

public class Solution2420 {
    class Solution {
        public List<Integer> goodIndices(int[] nums, int k) {
            int n = nums.length;
            int[] f = new int[n], g = new int[n];
            f[0] = 1;
            g[n - 1] = 1;
            for (int i = 1; i < n; i++) {
                if (nums[i - 1] >= nums[i]) {
                    f[i] = f[i - 1] + 1;
                } else {
                    f[i] = 1;
                }
            }
            for (int i = n - 2; i >= 0; i--) {
                if (nums[i] <= nums[i + 1]) {
                    g[i] = g[i + 1] + 1;
                } else {
                    g[i] = 1;
                }
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = k; i < n - k; i++) {
                if (f[i - 1] >= k && g[i + 1] >= k) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}