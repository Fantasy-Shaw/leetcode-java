package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution76 {
    class Solution {
        public String minWindow(String s, String t) {
            int[] mapS = new int[128], mapT = new int[128];
            for (char ch : t.toCharArray()) {
                mapT[ch]++;
            }
            int l = 0, r = 0;
            int beginIdx = -1, len = Integer.MAX_VALUE;
            char[] cs = s.toCharArray();
            while (r < s.length()) {
                if (mapT[cs[r]] != 0) {
                    mapS[cs[r]]++;
                }
                r++;
                while (isValid(mapS, mapT) && l <= r) {
                    if (r - l < len) {
                        len = r - l;
                        beginIdx = l;
                    }
                    if (mapT[cs[l]] != 0) {
                        mapS[cs[l]]--;
                    }
                    l++;
                }
            }
            return len < Integer.MAX_VALUE ? s.substring(beginIdx, beginIdx + len) : "";
        }

        private boolean isValid(int[] mapS, int[] mapT) {
            for (int i = 'A'; i <= 'Z'; i++) {
                if (mapS[i] < mapT[i]) {
                    return false;
                }
            }
            for (int i = 'a'; i <= 'z'; i++) {
                if (mapS[i] < mapT[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}