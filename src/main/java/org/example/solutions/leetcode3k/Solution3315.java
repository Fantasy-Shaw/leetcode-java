package org.example.solutions.leetcode3k;

import java.util.List;

public class Solution3315 {
    static
    class Solution {
        public int[] minBitwiseArray(List<Integer> nums) {
            int n = nums.size();
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int x = nums.get(i);
                if (x == 2) {
                    ans[i] = -1;
                } else {
                    int j = 0;
                    int cur = Integer.MAX_VALUE;
                    for (; j < 32; j++) {
                        if (((x >> j) & 1) == 1) {
                            cur = Math.min(cur, x ^ (1 << j));
                        } else {
                            break;
                        }
                    }
                    ans[i] = cur;
                }

            }
            return ans;
        }
    }
}