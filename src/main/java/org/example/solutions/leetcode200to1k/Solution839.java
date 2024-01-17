package org.example.solutions.leetcode200to1k;

import org.example.templates.UnionFind;

public class Solution839 {
    class Solution {
        public int numSimilarGroups(String[] strs) {
            UnionFind uf = new UnionFind(strs.length);
            for (int i = 0; i < strs.length; i++) {
                for (int j = i + 1; j < strs.length; j++) {
                    if (uf.isConnected(i, j)) {
                        continue;
                    }
                    if (isSimilar(strs[i], strs[j])) {
                        uf.union(i, j);
                    }
                }
            }
            return uf.getCount();
        }

        private static boolean isSimilar(String s1, String s2) {
            int diff = 0;
            if (s1.length() != s2.length()) return false;
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (++diff > 2) return false;
                }
            }
            return true;
        }
    }
}