package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3306 {
    static
    class Solution {
        public long countOfSubstrings(String word, int k) {
            char[] s = word.toCharArray();
            return f(s, k) - f(s, k + 1);
        }

        private long f(char[] s, int k) {
            int[] cnt = new int[6];
            long ans = 0;
            int left = 0;
            for (char c : s) {
                cnt[idx(c)]++;
                while (isValid(cnt, k)) {
                    cnt[idx(s[left])]--;
                    left++;
                }
                ans += left;
            }
            return ans;
        }

        private static int idx(char vowel) {
            return switch (vowel) {
                case 'a' -> 0;
                case 'e' -> 1;
                case 'i' -> 2;
                case 'o' -> 3;
                case 'u' -> 4;
                default -> 5;
            };
        }

        private static boolean isValid(int[] cnt, int k) {
            for (int i = 0; i < 5; i++) {
                if (cnt[i] == 0) {
                    return false;
                }
            }
            return cnt[5] >= k;
        }
    }
}