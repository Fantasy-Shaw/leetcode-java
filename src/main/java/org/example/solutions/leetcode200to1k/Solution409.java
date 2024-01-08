package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution409 {
    class Solution {
        public int longestPalindrome(String s) {
            int[] map = new int[128];
            for (char ch : s.toCharArray()) {
                map[ch]++;
            }
            boolean usedOddChar = false;
            int ans = 0;
            for (int i = 0; i < 128; i++) {
                int n = map[i];
                if (n == 0) continue;
                if (n % 2 == 1) {
                    if (!usedOddChar) {
                        ans += n;
                        usedOddChar = true;
                    } else {
                        ans += (n - 1);
                    }
                } else {
                    ans += n;
                }
            }
            return ans;
        }
    }
}