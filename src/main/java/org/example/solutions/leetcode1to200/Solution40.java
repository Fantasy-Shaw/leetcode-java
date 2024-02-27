package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            boolean[] vis = new boolean[candidates.length];
            dfs(ans, cur, 0, candidates, 0, target, vis);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> cur, int sum, int[] candidates, int idx, int target, boolean[] vis) {
            if (sum == target) {
                ans.add(new ArrayList<>(cur));
            }
            if (sum > target) {
                return;
            }
            for (int i = idx; i < candidates.length; i++) {
                // take the left one
                if (i > 0 && candidates[i] == candidates[i - 1] && !vis[i - 1]) {
                    continue;
                }
                cur.add(candidates[i]);
                vis[i] = true;
                dfs(ans, cur, sum + candidates[i], candidates, i + 1, target, vis);
                cur.removeLast();
                vis[i] = false;
            }
        }
    }
}