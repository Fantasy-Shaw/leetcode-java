package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2772 {
    private class Solution {
        public boolean checkArray(int[] nums, int k) {
            int n = nums.length;
            int[] d = new int[n + 1];
            d[0] = nums[0];
            for (int i = 1; i < n; i++) {
                d[i] = nums[i] - nums[i - 1];
            }
            d[n] = -nums[n - 1];
            for (int i = 0; i + k <= n; i++) {
                if (d[i] < 0) {
                    return false;
                } else if (d[i] == 0) {
                    continue;
                } else {
                    d[i + k] += d[i];
                    d[i] = 0;
                }
            }
            for (int i = n - k + 1; i <= n; i++) {
                if (d[i] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}