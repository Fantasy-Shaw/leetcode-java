package org.example.solutions.leetcode1kto2k;

public class Solution1231 {
    class Solution {
        private int[] sweetness;

        public int maximizeSweetness(int[] sweetness, int k) {
            this.sweetness = sweetness;
            int sum = 0;
            for (int n : sweetness) {
                sum += n;
            }
            int avg = sum / (k + 1);
            int l = 0, r = avg, mid = (l + r) / 2;
            while (l <= r) {
                if (check(mid, k)) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
                mid = (l + r) / 2;
            }
            return mid;
        }

        private boolean check(int minDiv, int k) {
            int cnt = 0, sum = 0;
            for (int n : sweetness) {
                sum += n;
                if (sum >= minDiv) {
                    sum = 0;
                    cnt++;
                }
            }
            return cnt >= k + 1;
        }
    }
}