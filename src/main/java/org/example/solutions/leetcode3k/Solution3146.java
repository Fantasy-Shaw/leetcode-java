package org.example.solutions.leetcode3k;

public class Solution3146 {
    class Solution {
        public int findPermutationDifference(String s, String t) {
            int[] idx = new int[26];
            for (int i = 0; i < s.length(); i++) {
                idx[s.charAt(i) - 'a'] = i;
            }
            int ans = 0;
            for (int i = 0; i < t.length(); i++) {
                ans += Math.abs(idx[t.charAt(i) - 'a'] - i);
            }
            return ans;
        }
    }
}