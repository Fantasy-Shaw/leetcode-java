package org.example.solutions.leetcode3k;

import java.util.HashMap;

public class Solution3045 {
    class Solution {
        public long countPrefixSuffixPairs(String[] words) {
            long ans = 0;
            TrieNode2D root = new TrieNode2D();
            for (String s : words) {
                int n = s.length();
                TrieNode2D cur = root;
                for (int i = 0; i < n; i++) {
                    int key = (int) s.charAt(i) << 16 | s.charAt(n - i - 1);
                    cur.children.putIfAbsent(key, new TrieNode2D());
                    cur = cur.children.get(key);
                    ans += cur.cnt;
                }
                cur.cnt++;
            }
            return ans;
        }

        static class TrieNode2D {
            // public TrieNode2D[][] children = new TrieNode2D[26][26];
            public HashMap<Integer, TrieNode2D> children = new HashMap<>();
            public int cnt = 0;
        }
    }
}