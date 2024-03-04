package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3065 {
    class Solution {
        public int minOperations(int[] nums, int k) {
            Arrays.sort(nums);
            int ans = 0;
            for (int i : nums) {
                if (i >= k) {
                    break;
                } else {
                    ans++;
                }
            }
            return ans;
        }
    }
}