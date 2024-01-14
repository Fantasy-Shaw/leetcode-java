package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2182 {
    class Solution {
        public String repeatLimitedString(String s, int repeatLimit) {
            int[] map = new int[128];
            for (char c : s.toCharArray()) {
                map[c]++;
            }
            StringBuilder ans = new StringBuilder();
            int curRepeat = 0;
            for (int i = 'z', j = 'z' - 1; i >= 'a' && j >= 'a'; ) {
                if (map[i] == 0) {
                    i--;
                    curRepeat = 0;
                } else if (curRepeat < repeatLimit) {
                    curRepeat++;
                    ans.append((char) i);
                    map[i]--;
                } else if (j >= i || map[j] == 0) {
                    j--;
                } else {
                    map[j]--;
                    ans.append((char) j);
                    curRepeat = 0;
                }
            }
            return ans.toString();
        }
    }
}