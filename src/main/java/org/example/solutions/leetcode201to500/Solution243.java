package org.example.solutions.leetcode201to500;

public class Solution243 {
    class Solution {
        public int shortestDistance(String[] wordsDict, String word1, String word2) {
            int idx1 = -1, idx2 = -1;
            int ans = wordsDict.length;
            for (int i = 0; i < wordsDict.length; i++) {
                if (word1.equals(wordsDict[i])) {
                    idx1 = i;
                    if (idx2 != -1) {
                        ans = Math.min(ans, Math.abs(idx1 - idx2));
                    }
                }
                if (word2.equals(wordsDict[i])) {
                    idx2 = i;
                    if (idx1 != -1) {
                        ans = Math.min(ans, Math.abs(idx1 - idx2));
                    }
                }
            }
            return ans;
        }
    }
}