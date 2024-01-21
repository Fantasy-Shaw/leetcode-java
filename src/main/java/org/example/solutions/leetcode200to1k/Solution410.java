package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution410 {
    class Solution {
        public int splitArray(int[] nums, int k) {
            int sum = 0;
            int mx = 0;
            for (int x : nums) {
                sum += x;
                mx = Math.max(mx, x);
            }
            int left = Math.max(mx - 1, (sum - 1) / k), right = sum;
            while (left + 1 < right) {
                int mid = left + (right - left) / 2;
                if (check(nums, k, mid)) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
            return right;
        }

        private boolean check(int[] nums, int k, int mx) {
            int cnt = 1;
            int curSegSum = 0;
            for (int x : nums) {
                if (curSegSum + x <= mx) {
                    curSegSum += x;
                } else { // new seg
                    if (cnt == k) {
                        return false;
                    }
                    cnt++;
                    curSegSum = x;
                }
            }
            return true;
        }
    }

    class SolutionDP {
        public int splitArray(int[] nums, int k) {
            int n = nums.length;
            long[][] f = new long[n + 1][k + 1];
            for (var i : f) {
                Arrays.fill(i, Long.MAX_VALUE);
            }
            long[] sub = new long[n + 1];
            for (int i = 0; i < n; i++) {
                sub[i + 1] = sub[i] + nums[i];
            }
            f[0][0] = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1, end = Math.min(i, k); j <= end; j++) {
                    for (int x = 0; x < i; x++) {
                        f[i][j] = Math.min(f[i][j], Math.max(f[x][j - 1], sub[i] - sub[x]));
                    }
                }
            }
            return (int) f[n][k];
        }
    }
}