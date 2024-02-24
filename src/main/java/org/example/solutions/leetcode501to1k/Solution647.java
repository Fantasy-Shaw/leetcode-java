package org.example.solutions.leetcode501to1k;

public class Solution647 {
    class Solution {
        public int countSubstrings(String s) {
            int n = s.length(), ans = 0;
            char[] cs = s.toCharArray();
            for (int i = 0; i < 2 * n - 1; i++) {
                int l = i / 2, r = i / 2 + i % 2;
                while (l >= 0 && r < n && cs[l--] == cs[r++]) {
                    ans++;
                }
            }
            return ans;
        }
    }
}