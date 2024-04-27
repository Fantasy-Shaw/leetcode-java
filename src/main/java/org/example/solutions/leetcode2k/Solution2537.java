package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2537 {
    class Solution {
        public long countGood(int[] nums, int k) {
            Map<Integer, Integer> freq = new HashMap<>();
            int n = nums.length, cnt = 0;
            long ans = 0;
            for (int i = 0, j = 0; i < n; i++) {
                cnt += freq.getOrDefault(nums[i], 0);
                freq.merge(nums[i], 1, Integer::sum);
                ans += j; // [0,j-1] can be the left bound
                while (j < n && cnt >= k) {
                    cnt -= freq.merge(nums[j], -1, Integer::sum); // cnt -= [merged]
                    j++;
                    ans++;
                }
            }
            return ans;
        }
    }
}