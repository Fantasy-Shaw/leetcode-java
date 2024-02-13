package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution325 {
    class Solution {
        public int maxSubArrayLen(int[] nums, int k) {
            int[] sum = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < sum.length; i++) {
                // Bigger indices cover smaller ones.
                map.put(sum[i], i);
            }
            int ans = 0;
            // sum[j] - sum[i] == k
            for (int i = 0; i < sum.length; i++) {
                int target = sum[i] + k;
                // if map doesn't contains target, curAns < 0.
                ans = Math.max(ans, map.getOrDefault(target, -1) - i);
            }
            return ans;
        }
    }
}