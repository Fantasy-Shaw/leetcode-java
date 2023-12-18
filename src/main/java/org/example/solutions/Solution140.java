package org.example.solutions;

import java.util.*;

public class Solution140 {
    private class Solution {
        private List<String> res = new ArrayList<>();
        private StringBuilder path = new StringBuilder();

        private void traceBack(String s, Set<String> wordSet, int idx) {
            if (idx == s.length()) {
                res.add(path.substring(0, path.length() - 1));
                return;
            }
            for (int i = 1; i <= s.length() - idx; i++) {
                String sub_str = s.substring(idx, idx + i);
                if (wordSet.contains(sub_str)) {
                    path.append(sub_str).append(' ');
                    traceBack(s, wordSet, idx + i);
                    path.delete(path.length() - sub_str.length() - 1, path.length());
                }
            }
        }

        public List<String> wordBreak(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            traceBack(s, wordSet, 0);
            return res;
        }
    }
}