package org.example.solutions.leetcode1to200;

import java.util.ArrayList;
import java.util.List;

public class Solution46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            boolean[] vis = new boolean[nums.length];
            dfs(ans, nums, new ArrayList<>(), vis);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> cur, boolean[] vis) {
            if (cur.size() == nums.length) {
                ans.add(new ArrayList<>(cur));
            }
            for (int i = 0; i < nums.length; i++) {
                if (!vis[i]) {
                    cur.add(nums[i]);
                    vis[i] = true;
                    dfs(ans, nums, cur, vis);
                    vis[i] = false;
                    cur.removeLast();
                }
            }
        }
    }
}