package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution15 {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> ans = new ArrayList<>();
            int n = nums.length;
            if (n < 3) {
                return ans;
            }
            for (int i = 0; i < n; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int j = i + 1, k = n - 1;
                while (j < k) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        j++;
                        continue;
                    }
                    if (k < n - 1 && nums[k] == nums[k + 1]) {
                        k--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum > 0) k--;
                    else if (sum < 0) j++;
                    else {
                        ans.add(List.of(nums[i], nums[j], nums[k]));
                        j++;
                    }
                }
            }
            return ans;
        }
    }
}