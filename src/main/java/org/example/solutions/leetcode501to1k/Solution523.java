package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution523 {
    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            // if (n-m)%k==0 : n%k==m%k
            int n = nums.length;
            if (n < 2) {
                return false;
            }
            long sum = 0;
            Map<Long, Integer> map = new HashMap<>();
            map.put(0L, 0);
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                sum %= k;
                if (map.containsKey(sum)) {
                    if (i - map.get(sum) >= 1) return true;
                } else {
                    map.put(sum, i + 1);
                }
            }
            return false;
        }
    }
}