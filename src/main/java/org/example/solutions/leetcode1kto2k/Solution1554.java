package org.example.solutions.leetcode1kto2k;

public class Solution1554 {
    class Solution {
        public boolean differByOne(String[] dict) {
            int n = dict.length, m = dict[0].length();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int cnt = 0;
                    for (int k = 0; k < m; k++) {
                        if (dict[i].charAt(k) != dict[j].charAt(k)) {
                            if (++cnt > 1) break;
                        }
                    }
                    if (cnt == 1) return true;
                }
            }
            return false;
        }
    }
}