package org.example.solutions.leetcode3k;

public class Solution3168 {
    class Solution {
        public int minimumChairs(String s) {
            int ans = 0, cur = 0;
            for (char ch : s.toCharArray()) {
                if (ch == 'E') {
                    cur++;
                } else {
                    cur--;
                }
                ans = Math.max(ans, cur);
            }
            return ans;
        }
    }
}