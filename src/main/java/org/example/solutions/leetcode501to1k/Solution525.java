package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution525 {
    class Solution {
        public int findMaxLength(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nums[i] = -1;
                }
            }
            int sum = 0, ans = 0;
            map.put(0, sum);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i]; // sum[i+1] = sum[i]+nums[i]
                if (map.containsKey(sum)) {
                    ans = Math.max(ans, i + 1 - map.get(sum));
                } else {
                    map.put(sum, i + 1);
                }
            }
            return ans;
        }
    }
}