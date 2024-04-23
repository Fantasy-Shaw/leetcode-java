package org.example.solutions.leetcode1kto2k;

public class Solution1052 {
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
            int n = customers.length;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += customers[i] * (~grumpy[i] & 1);
            }
            int ans = sum;
            int pre = 0, post = 0;
            for (int i = 0; i < minutes; i++) {
                pre += customers[i] * (~grumpy[i] & 1);
                post += customers[i];
            }
            ans = Math.max(ans, sum + post - pre);
            for (int i = minutes; i < n; i++) {
                pre -= customers[i - minutes] * (~grumpy[i - minutes] & 1);
                pre += customers[i] * (~grumpy[i] & 1);
                post -= customers[i - minutes];
                post += customers[i];
                ans = Math.max(ans, sum + post - pre);
            }
            return ans;
        }
    }
}