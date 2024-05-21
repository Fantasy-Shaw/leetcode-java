package org.example.solutions.leetcode3k;

public class Solution3153 {
    class Solution {
        public long sumDigitDifferences(int[] nums) {
            int n = nums.length;
            int[][] cnt = new int[10][10];
            for (int x : nums) {
                for (int i = 0; i < 10 && x > 0; i++) {
                    cnt[i][x % 10]++;
                    x /= 10;
                }
            }
//        System.out.println(Arrays.deepToString(cnt));
            long ans = 0;
            for (var x : cnt) {
//            System.out.println(Arrays.toString(x));
                for (int i = 0; i < 10; i++) {
                    for (int j = i + 1; j < 10; j++) {
                        ans += (long) x[i] * x[j];
                    }
                }
            }
            return ans;
        }
    }
}