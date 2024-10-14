package org.example.solutions.leetcode1to200;

import java.util.Arrays;

public class Solution164 {
    class Solution {
        // Radix sort
        public int maximumGap(int[] nums) {
            final int n = nums.length;
            if (n < 2) {
                return 0;
            }
            long exp = 1;
            int[] buf = new int[n];
            int maxVal = Arrays.stream(nums).max().getAsInt();

            while (maxVal >= exp) {
                int[] cnt = new int[10];
                for (int i = 0; i < n; i++) {
                    int digit = (nums[i] / (int) exp) % 10;
                    cnt[digit]++;
                }
                for (int i = 1; i < 10; i++) {
                    cnt[i] += cnt[i - 1];
                }
                for (int i = n - 1; i >= 0; i--) {
                    int digit = (nums[i] / (int) exp) % 10;
                    buf[cnt[digit] - 1] = nums[i];
                    cnt[digit]--;
                }
                System.arraycopy(buf, 0, nums, 0, n);
                exp *= 10;
            }
            int ans = 0;
            for (int i = 1; i < n; i++) {
                ans = Math.max(ans, nums[i] - nums[i - 1]);
            }
            return ans;
        }
    }

    class Solution_legacy {
        public int maximumGap(int[] nums) {
            if (nums.length < 2) {
                return 0;
            }
            Arrays.sort(nums);
            int diff = -1;
            for (int i = 1; i < nums.length; i++) {
                diff = Math.max(diff, nums[i] - nums[i - 1]);
            }
            return diff;
        }
    }

    class Solution1 {
        //bucket
        public int maximumGap(int[] nums) {
            final int n = nums.length;
            if (n < 2) {
                return 0;
            }
            int mn = Arrays.stream(nums).min().getAsInt();
            int mx = Arrays.stream(nums).max().getAsInt();
            int d = Math.max(1, (mx - mn) / (n - 1));
            int bucketSize = (mx - mn) / d + 1;
            int[][] bucket = new int[bucketSize][2];
            for (int i = 0; i < bucketSize; i++) {
                Arrays.fill(bucket[i], -1); // empty bucket = {-1, -1}
            }
            for (int num : nums) {
                int idx = (num - mn) / d;
                if (bucket[idx][0] == -1) {
                    bucket[idx][0] = bucket[idx][1] = num;
                } else {
                    bucket[idx][0] = Math.min(bucket[idx][0], num);
                    bucket[idx][1] = Math.max(bucket[idx][1], num);
                }
            }
            int ans = 0, prev = -1;
            for (int i = 0; i < bucketSize; i++) {
                if (bucket[i][0] == -1) {
                    continue;
                }
                if (prev != -1) {
                    ans = Math.max(ans, bucket[i][0] - bucket[prev][1]);
                }
                prev = i;
            }
            return ans;
        }
    }
}