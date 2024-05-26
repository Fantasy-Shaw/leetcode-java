package org.example.solutions.leetcode2k;

public class Solution2904 {
    class Solution {
        public String shortestBeautifulSubstring(String s, int k) {
            String ans = "";
            int cnt = 0, i = 0, j = 0, n = s.length();
            while (i < n && j < n) {
                while (j < n && cnt < k) {
                    if (s.charAt(j) == '1') {
                        cnt++;
                    }
                    j++;
                }
                while (i < j && cnt >= k) {
                    if (cnt == k) {
                        String cur = s.substring(i, j);
                        if (ans.isEmpty() || cur.length() < ans.length() ||
                                (cur.length() == ans.length() && cur.compareTo(ans) < 0)
                        ) {
                            ans = cur;
                        }
                    }
                    if (s.charAt(i) == '1') {
                        cnt--;
                    }
                    i++;
                }
            }
            return ans;
        }
    }
}