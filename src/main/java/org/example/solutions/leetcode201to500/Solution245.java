package org.example.solutions.leetcode201to500;

public class Solution245 {
    class Solution {
        public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
            int n = wordsDict.length;
            int ans = n;
            if (word1.equals(word2)) {
                int prev = -1;
                for (int i = 0; i < wordsDict.length; i++) {
                    if (wordsDict[i].equals(word1)) {
                        if (prev == -1) prev = i;
                        else {
                            ans = Math.min(i - prev, ans);
                            prev = i;
                        }
                    }
                }
                return ans;
            } else {
                int idx1 = -1, idx2 = -1;
                for (int i = 0; i < wordsDict.length; i++) {
                    if (word1.equals(wordsDict[i])) {
                        idx1 = i;
                        if (idx2 != -1) {
                            ans = Math.min(ans, Math.abs(idx1 - idx2));
                        }
                    } else if (word2.equals(wordsDict[i])) {
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
}