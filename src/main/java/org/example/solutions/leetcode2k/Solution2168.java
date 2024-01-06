package org.example.solutions.leetcode2k;

import org.example.templates.StringHash;

import java.util.*;

public class Solution2168 {
    class Solution {
        private char[] cs;
        private int[][] digitFreqPrefix;

        public int equalDigitFrequency(String s) {
            int n = s.length();
            cs = s.toCharArray();
            digitFreqPrefix = new int[n + 1][10];
            for (int i = 1; i <= n; i++) {
                int u = cs[i - 1] - '0';
                for (int j = 0; j < 10; j++) {
                    if (u == j) {
                        digitFreqPrefix[i][j] = digitFreqPrefix[i - 1][j] + 1;
                    } else {
                        digitFreqPrefix[i][j] = digitFreqPrefix[i - 1][j];
                    }
                }
            }
            StringHash hash = new StringHash(s);
            Set<Long> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n + 1; j++) {
                    long h = hash.getSubStrHash(i, j);
                    if (set.contains(h)) continue;
                    if (!hasSameNumberOfTimes(i, j)) continue;
                    set.add(h);
                }
            }
            return set.size();
        }

        private boolean hasSameNumberOfTimes(int i, int j) {
            int freq = 0;
            for (int k = 0; k < 10; k++) {
                int digitFreq = digitFreqPrefix[j][k] - digitFreqPrefix[i][k];
                if (digitFreq == 0) continue;
                else {
                    if (freq == 0) freq = digitFreq;
                    else if (digitFreq != freq) return false;
                }
            }
            return true;
        }
    }
}