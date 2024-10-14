package org.example.solutions.leetcode1to200;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            dfs(ans, cur, 0, nums);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> cur, int i, int[] nums) {
            if (i == nums.length) {
                ans.add(new ArrayList<>(cur));
                return;
            }
            cur.add(nums[i]);
            dfs(ans, cur, i + 1, nums);
            cur.removeLast();
            dfs(ans, cur, i + 1, nums);
        }
    }
}