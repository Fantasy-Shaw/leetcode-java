package org.example.solutions.leetcode201to500;

import java.util.ArrayList;
import java.util.List;

public class Solution216 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            dfs(ans, cur, 1, 9, k, n);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> cur, int l, int r, int k, int n) {
            if (n == 0 && cur.size() == k) {
                ans.add(new ArrayList<>(cur));
                return;
            }
            if (n < 0 || l > r || cur.size() >= k) {
                return;
            }
            cur.add(l);
            dfs(ans, cur, l + 1, r, k, n - l);
            cur.removeLast();
            dfs(ans, cur, l + 1, r, k, n);
        }
    }
}