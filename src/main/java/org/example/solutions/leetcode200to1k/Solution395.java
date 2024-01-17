package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution395 {
    class Solution { // Two Pointers
        public int longestSubstring(String s, int k) {
            int ans = 0;
            int n = s.length();
            char[] cs = s.toCharArray();
            int[] cnt = new int[26];
            for (int p = 1; p <= 26; p++) {
                Arrays.fill(cnt, 0);
                int n_char = 0, sum = 0;
                for (int i = 0, j = 0; i < n; i++) {
                    int u = cs[i] - 'a';
                    if (++cnt[u] == 1) n_char++;
                    if (cnt[u] == k) sum++;
                    while (n_char > p) {
                        int t = cs[j++] - 'a';
                        if (--cnt[t] == 0) n_char--;
                        if (cnt[t] == k - 1) sum--;
                    }
                    if (n_char == sum) { // No character is removed.
                        ans = Math.max(ans, i - j + 1);
                    }
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public int longestSubstring(String s, int k) { // Prefix Sum
            int n = s.length();
            int[][] cntPrefixSum = new int[n + 1][26];
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < 26; j++) {
                    cntPrefixSum[i + 1][j] = cntPrefixSum[i][j];
                }
                int u = s.charAt(i) - 'a';
                cntPrefixSum[i + 1][u] = cntPrefixSum[i][u] + 1;
            }
            int maxLen = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1 + maxLen; j <= n; j++) {
                    int x = 0;
                    for (; x < 26; x++) {
                        int freq = cntPrefixSum[j][x] - cntPrefixSum[i][x];
                        if (freq != 0 && freq < k) break;
                    }
                    if (x == 26) {
                        maxLen = Math.max(maxLen, j - i);
                    }
                }
            }
            return maxLen;
        }
    }
}