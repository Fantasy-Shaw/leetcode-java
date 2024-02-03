package org.example.solutions.leetcode2k;

public class Solution2156 {
    class Solution {
        public String subStrHash(String s, int power, int mod, int k, int hashValue) {
            int n = s.length();
            String ans = "";
            int i = n - 1;
            long hash = 0, p = 1;
            for (; i >= n - k; i--) {
                hash = (hash * power + val(s.charAt(i))) % mod;
                p = p * power % mod;
            }
            if ((int) hash == hashValue) {
                ans = s.substring(n - k);
            }
            for (; i >= 0; i--) {
                hash = (hash * power + val(s.charAt(i)) + mod - p * val(s.charAt(i + k)) % mod) % mod;
                if ((int) hash == hashValue) {
                    ans = s.substring(i, i + k);
                }
            }
            return ans;
        }

        private static int val(char c) {
            return c - 'a' + 1;
        }
    }
}