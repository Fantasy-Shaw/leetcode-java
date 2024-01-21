package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution330 {
    class Solution {
        public int minPatches(int[] nums, int n) {
            int ans = 0;
            long s = 1;
            for (int i = 0; s <= n; ) {
                if (i < nums.length && nums[i] <= s) {
                    s += nums[i];
                    i++;
                } else {
                    s *= 2;
                    ans++;
                }
            }
            return ans;
        }
    }
}