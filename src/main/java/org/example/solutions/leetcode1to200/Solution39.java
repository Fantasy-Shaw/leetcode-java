package org.example.solutions.leetcode1to200;

import java.util.ArrayList;
import java.util.List;

public class Solution39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            dfs(candidates, target, 0, ans, cur);
            return ans;
        }

        private void dfs(int[] nums, int target, int left, List<List<Integer>> ans, List<Integer> cur) {
            if (target < 0) {
                return;
            }
            if (target == 0) {
                ans.add(new ArrayList<>(cur));
                return;
            }
            for (int i = left; i < nums.length; i++) {
                cur.add(nums[i]);
                dfs(nums, target - nums[i], i, ans, cur);
                cur.removeLast();
            }
        }
    }
}