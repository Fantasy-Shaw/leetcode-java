package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1671 {
    class Solution {
        public int minimumMountainRemovals(int[] nums) {
            int n = nums.length;
            int[] prefix = getLISArray(nums);
            int[] suffix = getReversed(getLISArray(getReversed(nums)));

            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (prefix[i] > 1 && suffix[i] > 1) {
                    ans = Math.max(ans, prefix[i] + suffix[i] - 1);
                }
            }
            return n - ans;
        }

        private int[] getLISArray(int[] nums) {
            // Binary Search, O(NlogN)
            int n = nums.length;
            int[] dp = new int[n];
            List<Integer> seq = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int idx = binarySearch(seq, nums[i]);
                if (idx == seq.size()) {
                    seq.add(nums[i]);
                    dp[i] = seq.size();
                } else {
                    seq.set(idx, nums[i]);
                    dp[i] = idx + 1;
                }
            }
            return dp;
        }

        private int[] getReversed(int[] nums) {
            int[] rev = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                rev[i] = nums[nums.length - i - 1];
            }
            return rev;
        }

        private int binarySearch(List<Integer> seq, int target) {
            int low = 0, high = seq.size();
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (seq.get(mid) >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            return low;
        }

//        private int[] getLISArray(int[] nums) {
//        // dp, O(N^2)
//        int n = nums.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[j] < nums[i]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//        return dp;
//    }
    }
}