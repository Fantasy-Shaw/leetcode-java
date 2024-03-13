package org.example.solutions.leetcode2k;

public class Solution2864 {
    class Solution {
        public String maximumOddBinaryNumber(String s) {
            int[] cnt = new int[2];
            for (char ch : s.toCharArray()) {
                cnt[ch - '0']++;
            }
            StringBuilder ans = new StringBuilder();
            while (cnt[1] > 1) {
                ans.append(1);
                cnt[1]--;
            }
            for (int i = 0; i < cnt[0]; i++) {
                ans.append(0);
            }
            ans.append(1);
            return ans.toString();
        }
    }
}