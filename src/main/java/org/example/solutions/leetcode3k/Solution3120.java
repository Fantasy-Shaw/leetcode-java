package org.example.solutions.leetcode3k;

public class Solution3120 {
    class Solution {
        public int numberOfSpecialChars(String word) {
            int[] cnt = new int[128];
            for (char ch : word.toCharArray()) {
                cnt[ch]++;
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                if (cnt['a' + i] > 0 && cnt['A' + i] > 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
}