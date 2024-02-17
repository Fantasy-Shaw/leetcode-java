package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3035 {
    class Solution {
        public int maxPalindromesAfterOperations(String[] words) {
            int oddL = 0, mask = 0;
            for (var w : words) {
                oddL += w.length() % 2;
                for (int i = 0; i < w.length(); i++) {
                    mask ^= 1 << (w.charAt(i) - 'a');
                }
            }
            Arrays.sort(words, (a, b) -> b.length() - a.length());
            int ans = words.length;
            int left = Integer.bitCount(mask) - oddL;
            for (var w : words) {
                if (left <= 0) {
                    break;
                }
                left -= w.length() / 2 * 2;
                ans--;
            }
            return ans;
        }
    }
}