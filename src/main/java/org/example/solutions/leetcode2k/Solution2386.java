package org.example.solutions.leetcode2k;

import java.util.Arrays;

public class Solution2386 {
    class Solution {
        int cnt = 0;

        public long kSum(int[] nums, int k) {
            int n = nums.length;
            long sum = 0, absSum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.max(nums[i], 0);
                nums[i] = Math.abs(nums[i]);
                absSum += nums[i];
            }
            Arrays.sort(nums);
            long l = 0, r = absSum + 1;
            while (l < r) {
                long mid = l + (r - l) / 2;
                cnt = 1; // sum of empty list == 0
                dfs(0, 0, mid, nums, k);
                if (cnt < k) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return sum - l;
        }

        private void dfs(int i, long cur, long target, int[] nums, int k) {
            if (cnt == k || i >= nums.length || cur + nums[i] > target) {
                return;
            }
            cnt++;
            dfs(i + 1, cur + nums[i], target, nums, k);
            dfs(i + 1, cur, target, nums, k);
        }
    }

    class Solution1 {
        int cnt = 0;

        public long kSum(int[] nums, int k) {
            int n = nums.length;
            long sum = 0, absSum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.max(nums[i], 0);
                nums[i] = Math.abs(nums[i]);
                absSum += nums[i];
            }
            Arrays.sort(nums);
            long l = 0, r = absSum + 1;
            while (l < r) {
                long mid = l + (r - l) / 2;
                cnt = k - 1;
                dfs(0, mid, nums);
                if (cnt > 0) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return sum - l;
        }

        private void dfs(int i, long s, int[] nums) {
            if (cnt == 0 || i == nums.length || s < nums[i]) {
                return;
            }
            cnt--;
            dfs(i + 1, s - nums[i], nums);
            dfs(i + 1, s, nums);
        }
    }
}