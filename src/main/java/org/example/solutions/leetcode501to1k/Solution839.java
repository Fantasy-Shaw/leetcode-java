package org.example.solutions.leetcode501to1k;

import org.example.templates.UnionFind;

import java.util.Arrays;

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
            int[] cnt = new int[26];
            for (int i = 0; i < s1.length(); i++) {
                char c1 = s1.charAt(i), c2 = s2.charAt(i);
                if (c1 != c2) {
                    if (++diff > 2) return false;
                }
                cnt[c1 - 'a']++;
                cnt[c2 - 'a']--;
            }
            return Arrays.stream(cnt).sum() == 0;
        }
    }
}