package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution386 {
    class Solution {
        private List<Integer> ans;
        private int limit;

        public List<Integer> lexicalOrder(int n) {
            this.limit = n;
            ans = new ArrayList<>(n + 1);
            for (int i = 1; i <= 9; i++) {
                dfs(i);
            }
            return ans;
        }

        private void dfs(int cur) {
            if (cur > limit) return;
            ans.add(cur);
            for (int i = 0; i <= 9; i++) {
                dfs(cur * 10 + i);
            }
        }
    }
}