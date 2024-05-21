package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1553 {
    class Solution {
        public int minDays(int n) {
            Map<Integer, Integer> memo = new HashMap<>();
            return dfs(n, memo);
        }

        private int dfs(int n, Map<Integer, Integer> memo) {
            if (n <= 1) {
                return n;
            }
            if (memo.containsKey(n)) return memo.get(n);
            int ans = 1 + Math.min(n % 2 + dfs(n / 2, memo), n % 3 + dfs(n / 3, memo));
            memo.put(n, ans);
            return ans;
        }
    }
}