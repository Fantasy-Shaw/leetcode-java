package org.example.solutions.leetcode2k;

public class Solution2555 {
    class Solution {
        public int maximizeWin(int[] prizePositions, int k) {
            int n = prizePositions.length;
            if (prizePositions[n - 1] - prizePositions[0] < k * 2 + 2) {
                return n;
            }
            int ans = 0;
            int left = 0;
            int[] mx = new int[n + 1];
            for (int right = 0; right < n; right++) {
                while (prizePositions[right] - prizePositions[left] > k) {
                    left++;
                }
                int curRight = right - left + 1;
                ans = Math.max(ans, mx[left] + curRight);
                mx[right + 1] = Math.max(mx[right], curRight);
            }
            return ans;
        }
    }
}