package org.example.solutions.leetcode501to1k;

import java.util.HashMap;
import java.util.Map;

public class Solution808 {
    static class Solution {
        public double soupServings(int n) {
            if (n > 4500) {
                return 1;
            }
            // long : pair<int, int>
            Map<Long, Double> memo = new HashMap<>();
            return dfs(n, n, memo);
        }

        private double dfs(int a, int b, Map<Long, Double> memo) {
            if (a <= 0 && b <= 0) {
                return 0.5;
            }
            if (a <= 0) {
                return 1;
            }
            if (b <= 0) {
                return 0;
            }
            long key = (long) a << 32 | b;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            double ans = 0;
            ans += dfs(a - 100, b, memo);
            ans += dfs(a - 75, b - 25, memo);
            ans += dfs(a - 50, b - 50, memo);
            ans += dfs(a - 25, b - 75, memo);
            ans /= 4;
            memo.put(key, ans);
            return ans;
        }

        public static void main(String[] args) {
            Solution sln = new Solution();
            for (int i = 101; i < 1e5; i++) {
                double cur = sln.soupServings(i);
                if (Math.abs(cur - 1) <= 1e-5) {
                    System.out.println(i); // 4451
                    break;
                }
            }
        }
    }
}