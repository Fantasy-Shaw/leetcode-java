package org.example.solutions.leetcode501to1k;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution823 {
    class Solution {
        final long mod = (long) 1e9 + 7;
        HashMap<Integer, Long> memo;

        public int numFactoredBinaryTrees(int[] arr) {
            memo = new HashMap<>();
            int n = arr.length;
            Set<Integer> set = new HashSet<>();
            for (int x : arr) {
                set.add(x);
            }
            long ans = 0;
            for (int x : arr) {
                ans += dfs(x, arr, set);
                ans %= mod;
            }
            return (int) ans;
        }

        private long dfs(int val, int[] arr, Set<Integer> set) {
            if (memo.containsKey(val)) {
                return memo.get(val);
            }
            long res = 1;
            for (int x : arr) {
                if (val % x == 0 && set.contains(val / x)) {
                    res += dfs(x, arr, set) * dfs(val / x, arr, set);
                }
            }
            memo.put(val, res);
            return res;
        }
    }
}