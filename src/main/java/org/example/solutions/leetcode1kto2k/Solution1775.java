package org.example.solutions.leetcode1kto2k;

public class Solution1775 {
    class Solution {
        public int minOperations(int[] nums1, int[] nums2) {
            int sum1 = 0, sum2 = 0;
            for (int i : nums1) {
                sum1 += i;
            }
            for (int i : nums2) {
                sum2 += i;
            }
            if (sum1 == sum2) return 0;
            int diff = Math.abs(sum1 - sum2);
            int[] small = (sum1 < sum2) ? nums1 : nums2;
            int[] large = (sum1 < sum2) ? nums2 : nums1;
            int[] cnt = new int[6]; // 1 2 3 4 5
            for (int n : small) {
                cnt[6 - n]++;
            }
            for (int n : large) {
                cnt[n - 1]++;
            }
            int ans = 0;
            for (int i = 5; i >= 1; i--) {
                if (diff - cnt[i] * i <= 0) {
//                ans += (int) Math.ceil(diff * 1.0 / i);
                    ans += (diff + i - 1) / i;
                    return ans;
                } else {
                    diff -= cnt[i] * i;
                    ans += cnt[i];
                }
            }
            return -1;
        }
    }
}