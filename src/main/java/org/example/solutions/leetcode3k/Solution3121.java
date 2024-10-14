package org.example.solutions.leetcode3k;

import java.util.Arrays;

public class Solution3121 {
    class Solution {
        public int numberOfSpecialChars(String word) {
            int[] upperIdx = new int[128], lowerIdx = new int[128];
            Arrays.fill(upperIdx, -1);
            Arrays.fill(lowerIdx, -1);
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (Character.isUpperCase(ch)) {
                    upperIdx[ch] = upperIdx[ch] == -1 ? i : Math.min(upperIdx[ch], i);
                } else {
                    lowerIdx[ch] = lowerIdx[ch] == -1 ? i : Math.max(lowerIdx[ch], i);
                }
            }
            int ans = 0;
            for (int i = 0; i < 26; i++) {
                char low = (char) (i + 'a'), up = (char) (i + 'A');
                if (lowerIdx[low] == -1 || upperIdx[up] == -1) {
                    continue;
                }
                if (lowerIdx[low] < upperIdx[up]) {
                    ans++;
                }
            }
            return ans;
        }
    }
}