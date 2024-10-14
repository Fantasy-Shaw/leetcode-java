package org.example.solutions.leetcode501to1k;

import java.util.ArrayList;
import java.util.List;

public class Solution967 {
    class Solution {
        public int[] numsSameConsecDiff(int n, int k) {
            if (k == 0) {
                int[] ans = new int[9];
                int base = 0;
                for (int i = 0; i < n; i++) {
                    base = base * 10 + 1;
                }
                for (int i = 1; i <= 9; i++) {
                    ans[i - 1] = i * base;
                }
                return ans;
            }
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= 9; i++) {
                dfs(ans, i, 1, n, k);
            }
            return ans.stream().mapToInt(value -> value).toArray();
        }

        private void dfs(List<Integer> ans, int cur, int l, int n, int k) {
            if (l == n) {
                ans.add(cur);
                return;
            }
            int last = cur % 10;
            if (last - k >= 0) {
                dfs(ans, cur * 10 + (last - k), l + 1, n, k);
            }
            if (last + k <= 9) {
                dfs(ans, cur * 10 + (last + k), l + 1, n, k);
            }
        }
    }
}