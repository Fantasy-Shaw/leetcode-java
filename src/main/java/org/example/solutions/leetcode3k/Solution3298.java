package org.example.solutions.leetcode3k;

public class Solution3298 {
    class Solution {
        public long validSubstringCount(String word1, String word2) {
            char[] s1 = word1.toCharArray();
            char[] s2 = word2.toCharArray();
            int[] cnt2 = new int[26];
            for (char c : s2) {
                cnt2[c - 'a']++;
            }
            int[] cnt1 = new int[26];
            int n = s1.length, i = 0, j = 0;
            long ans = 0;
            while (i < n && j < n) {
                while (j < n && !isValid(cnt1, cnt2)) {
                    cnt1[s1[j++] - 'a']++;
                }
                while (i < n && isValid(cnt1, cnt2)) {
                    ans += (n - j + 1);
                    cnt1[s1[i++] - 'a']--;
                }
            }
            return ans;
        }

        private static boolean isValid(int[] x, int[] y) {
            for (int i = 0; i < 26; i++) {
                if (x[i] < y[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}