package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution833 {
    class Solution {
        public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
            int n = s.length();
            String[] replaceStr = new String[n];
            int[] replaceLen = new int[n];
            Arrays.fill(replaceLen, 1);
            for (int i = 0; i < indices.length; i++) {
                int idx = indices[i];
                if (s.startsWith(sources[i], idx)) {
                    replaceStr[idx] = targets[i];
                    replaceLen[idx] = sources[i].length();
                }
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i += replaceLen[i]) {
                ans.append(replaceStr[i] == null ? s.charAt(i) : replaceStr[i]);
            }
            return ans.toString();
        }
    }
}