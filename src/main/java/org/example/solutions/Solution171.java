package org.example.solutions;

public class Solution171 {
    class Solution {
        public int titleToNumber(String columnTitle) {
            int n = columnTitle.length();
            int scale = 1;
            int ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                ans += (columnTitle.charAt(i) - 'A' + 1) * scale;
                scale *= 26;
            }
            return ans;
        }
    }
}