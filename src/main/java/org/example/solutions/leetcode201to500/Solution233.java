package org.example.solutions.leetcode201to500;

public class Solution233 {
    class Solution {
        public int countDigitOne(int n) {
            String s = String.valueOf(n);
            int m = s.length();
            if (m == 1) {
                return n > 0 ? 1 : 0;
            }
            int[] prefix_n = new int[m], suffix_n = new int[m];
            suffix_n[0] = Integer.parseInt(s.substring(1));
            for (int i = 1; i < m - 1; i++) {
                prefix_n[i] = Integer.parseInt(s.substring(0, i));
                suffix_n[i] = Integer.parseInt(s.substring(i + 1));
            }
            prefix_n[m - 1] = Integer.parseInt(s.substring(0, m - 1));
            int ans = 0;
            for (int i = 0; i < m; i++) {
                int x = s.charAt(i) - '0', len = m - i - 1;
                int prefix = prefix_n[i], suffix = suffix_n[i];
                int tot = 0;
                tot += (int) (prefix * Math.pow(10, len));
                if (x == 1) {
                    tot += (suffix + 1);
                } else if (x > 1) {
                    tot += (int) (Math.pow(10, len));
                }
                ans += tot;
            }
            return ans;
        }
    }
}