package org.example.solutions.leetcode1to200;

import java.util.ArrayList;
import java.util.List;

public class Solution131 {
    class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            List<String> cur = new ArrayList<>();
            dfs(s, 0, ans, cur);
            return ans;
        }

        private void dfs(String s, int i, List<List<String>> ans, List<String> cur) {
            if (i >= s.length()) {
                ans.add(new ArrayList<>(cur));
            }
            for (int j = i + 1; j <= s.length(); j++) {
                String _s = s.substring(i, j);
                if (isPalindrome(_s)) {
                    cur.add(_s);
                    dfs(s, j, ans, cur);
                    cur.removeLast();
                }
            }
        }

        private boolean isPalindrome(String s) {
            int l = 0, r = s.length() - 1;
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) return false;
                l++;
                r--;
            }
            return true;
        }
    }
}