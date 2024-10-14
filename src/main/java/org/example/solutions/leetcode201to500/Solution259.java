package org.example.solutions.leetcode201to500;

import java.util.Arrays;

public class Solution259 {
    class Solution {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int n = nums.length, ans = 0;
            for (int i = 0; i < n - 2; i++) {
                int l = i + 1, r = n - 1;
                int t = target - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] < t) {
                        ans += (r - l);
                        l++;
                    } else {
                        r--;
                    }
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int threeSumSmaller(int[] nums, int target) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int k = lowerBound(nums, j + 1, nums.length, target - nums[i] - nums[j]);
                    ans += (k - (j + 1));
                }
            }
            return ans;
        }

        private static int lowerBound(int[] arr, int l, int r, int target) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (arr[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}