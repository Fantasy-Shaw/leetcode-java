package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> ans = new ArrayList<>();
            StringBuilder cur = new StringBuilder();
            dfs(ans, cur, 0, 0, n);
            return ans;
        }

        private void dfs(List<String> ans, StringBuilder cur, int l, int r, int n) {
            if (cur.length() == n * 2) {
                ans.add(cur.toString());
                return;
            }
            if (l < n) {
                cur.append('(');
                dfs(ans, cur, l + 1, r, n);
                cur.deleteCharAt(cur.length() - 1);
            }
            if (l > r) {
                cur.append(')');
                dfs(ans, cur, l, r + 1, n);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
}