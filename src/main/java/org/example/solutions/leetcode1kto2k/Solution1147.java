package org.example.solutions.leetcode1kto2k;

import org.example.templates.RolliingHash.StringHash;

public class Solution1147 {
    class Solution {
        private String text;
        private StringHash hash;

        public int longestDecomposition(String text) {
            if (text.isEmpty()) return 0;
            this.text = text;
            this.hash = new StringHash(text);
            return helper(0, text.length());
        }

        private int helper(int l, int r) {
            if (l == r) return 0;
            for (int i = l + 1, n = (r - l); i <= l + n / 2; i++) {
                if (hash.getHash(l, i) == hash.getHash(r - (i - l), r)) {
                    return 2 + helper(i, r - (i - l));
                }
            }
            return 1;
        }
    }
}