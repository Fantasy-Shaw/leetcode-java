package org.example.solutions.leetcode501to1k;

import java.util.ArrayList;
import java.util.List;

public class Solution784 {
    class Solution {
        int m;
        char[] cs;
        List<String> ans;

        public List<String> letterCasePermutation(String s) {
            m = s.length();
            this.cs = s.toCharArray();
            ans = new ArrayList<>();
            dfs(0);
            return ans;
        }

        private void dfs(int idx) {
            while (idx < m && Character.isDigit(cs[idx])) {
                idx++;
            }
            if (idx == m) {
                ans.add(new String(cs));
                return;
            }
            cs[idx] = upper(cs[idx]);
            dfs(idx + 1);
            cs[idx] = lower(cs[idx]);
            dfs(idx + 1);
        }

        private static char upper(char ch) {
            if ('A' <= ch && ch <= 'Z') return ch;
            return (char) ('A' + ch - 'a');
        }

        private static char lower(char ch) {
            if ('a' <= ch && ch <= 'z') return ch;
            return (char) ('a' + ch - 'A');
        }
    }
}