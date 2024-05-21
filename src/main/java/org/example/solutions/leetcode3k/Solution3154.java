package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3154 {
    class Solution {
        Map<Long, Integer> memo;

        public int waysToReachStair(int k) {
            memo = new HashMap<>();
            return dfs(1, 0, 0, k);
        }

        private int dfs(int step, int jump, int isPreBack, int k) {
            if (step > k + 1) {
                return 0;
            }
            long key = (long) step << 32 | jump << 1 | isPreBack;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            int ans = step == k ? 1 : 0;
            ans += dfs(step + (1 << jump), jump + 1, 0, k);
            if (isPreBack == 0 && step > 0) {
                ans += dfs(step - 1, jump, 1, k);
            }
            memo.put(key, ans);
            return ans;
        }
    }
}