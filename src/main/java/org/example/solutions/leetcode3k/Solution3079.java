package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3079 {
    class Solution {
        public int sumOfEncryptedInt(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                char[] s = String.valueOf(nums[i]).toCharArray();
                int x = s[0] - '0';
                for (int j = 1; j < s.length; j++) {
                    x = Math.max(x, s[j] - '0');
                }
                int cur = 0;
                for (int j = 0; j < s.length; j++) {
                    cur = cur * 10 + x;
                }
                nums[i] = cur;
            }
            return Arrays.stream(nums).sum();
        }
    }
}