package org.example.solutions.leetcode2k;

import java.util.Arrays;

public class Solution2707 {
    class Solution {
        private TrieNode root;

        public int minExtraChar(String s, String[] dictionary) {
            root = new TrieNode();
            int n = s.length();
            for (String word : dictionary) {
                add(word);
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                dp[i] = dp[i - 1] + 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (query(s.substring(j, i))) {
                        dp[i] = Math.min(dp[i], dp[j]);
                    }
                }
            }
            return dp[n];
        }

        private void add(String s) {
            TrieNode tr = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (tr.children[u] == null) {
                    tr.children[u] = new TrieNode();
                }
                tr = tr.children[u];
            }
            tr.isEnd = true;
        }

        private boolean query(String s) {
            TrieNode tr = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (tr.children[u] == null) {
                    return false;
                }
                tr = tr.children[u];
            }
            return tr.isEnd;
        }

        private static class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public boolean isEnd = false;
        }
    }
}