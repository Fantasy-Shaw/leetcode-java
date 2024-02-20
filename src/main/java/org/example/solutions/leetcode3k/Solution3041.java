package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3041 {
    class Solution {
        public int maxSelectedElements(int[] nums) {
            HashMap<Integer, Integer> dp = new HashMap<>();
            Arrays.sort(nums);
            for (int x : nums) {
                dp.put(x + 1, dp.getOrDefault(x, 0) + 1);
                dp.put(x, dp.getOrDefault(x - 1, 0) + 1);
            }
            int ans = 1;
            for (var i : dp.values()) {
                ans = Math.max(ans, i);
            }
            return ans;
        }
    }
}