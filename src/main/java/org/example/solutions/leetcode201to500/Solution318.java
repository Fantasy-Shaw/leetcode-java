package org.example.solutions.leetcode201to500;

public class Solution318 {
    class Solution {
        public int maxProduct(String[] words) {
            int n = words.length;
            int[] mask = new int[n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < words[i].length(); j++) {
                    mask[i] |= (1 << (words[i].charAt(j) - 'a'));
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((mask[i] & mask[j]) == 0) {
                        ans = Math.max(ans, words[i].length() * words[j].length());
                    }
                }
            }
            return ans;
        }
    }
}