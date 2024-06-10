package org.example.solutions.leetcode3k;

import java.util.ArrayList;
import java.util.List;

public class Solution3171 {
    class Solution {
        public int minimumDifference(int[] nums, int k) {
            List<Integer> grIdx = new ArrayList<>();
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                ans = Math.min(ans, Math.abs(nums[i] - k));
                if (nums[i] == k) {
                    return 0;
                } else if (nums[i] > k) {
                    grIdx.add(i);
                }
            }
            int m = grIdx.size();
            for (int i = 0, j = 0; i < m && j < m; ) {
                j = i + 1;
                while (j < m && grIdx.get(j) - grIdx.get(j - 1) == 1) {
                    j++;
                }
                int L = grIdx.get(i), R = grIdx.get(j - 1);
                int[] dig = new int[30];
                for (int l = L, r = L; l <= R && r <= R; ) {
                    while (r <= R && getDigit(dig, r - l) > k) {
                        add(dig, nums[r]);
                        ans = Math.min(ans, Math.abs(k - getDigit(dig, r - l + 1)));
                        r++;
                    }
                    ans = Math.min(ans, Math.abs(k - getDigit(dig, r - l)));
                    while (l < r && getDigit(dig, r - l) <= k) {
                        remove(dig, nums[l]);
                        ans = Math.min(ans, Math.abs(k - getDigit(dig, r - l - 1)));
                        l++;
                    }
                    ans = Math.min(ans, Math.abs(k - getDigit(dig, r - l)));
                }
                i = j;
            }
            return ans;
        }

        private void add(int[] dig, int x) {
            for (int i = 0; i < 30; i++) {
                dig[i] += ((x >> i) & 1);
            }
        }

        private void remove(int[] dig, int x) {
            for (int i = 0; i < 30; i++) {
                dig[i] -= ((x >> i) & 1);
            }
        }

        private int getDigit(int[] dig, int len) {
            int ans = 0;
            for (int i = 0; i < 30; i++) {
                if (dig[i] == len) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }
    }
}