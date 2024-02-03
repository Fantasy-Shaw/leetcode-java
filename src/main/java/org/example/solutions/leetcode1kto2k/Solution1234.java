package org.example.solutions.leetcode1kto2k;

public class Solution1234 {
    class Solution {
        public int balancedString(String s) {
            char[] cs = s.toCharArray();
            int[] map = new int[128];
            for (char ch : cs) {
                map[ch]++;
            }
            int n = s.length(), m = s.length() / 4;
            if (map['Q'] == m && map['W'] == m && map['E'] == m && map['R'] == m) {
                return 0;
            }
            int ans = n, l = 0;
            for (int r = 0; r < n; r++) {
                map[cs[r]]--;
                while (map['Q'] <= m && map['W'] <= m && map['E'] <= m && map['R'] <= m) {
                    ans = Math.min(ans, r - l + 1);
                    map[cs[l]]++;
                    l++;
                }
            }
            return ans;
        }
    }
}