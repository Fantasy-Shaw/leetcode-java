package org.example.solutions.leetcode501to1k;

import java.util.HashMap;
import java.util.Map;

public class Solution666 {
    class Solution {
        int ans;

        public int pathSum(int[] nums) {
            ans = 0;
            Map<Integer, Integer> biTree = new HashMap<>();
            for (int i : nums) {
                biTree.put(i / 10, i % 10);
            }
            dfs(biTree, nums[0] / 10, 0);
            return ans;
        }

        private void dfs(Map<Integer, Integer> biTree, int node, int sum) {
            if (!biTree.containsKey(node)) {
                return;
            }
            sum += biTree.get(node);
            int left = (node / 10 + 1) * 10 + 2 * (node % 10) - 1;
            int right = left + 1;
            if (!biTree.containsKey(left) && !biTree.containsKey(right)) {
                ans += sum;
                return;
            }
            dfs(biTree, left, sum);
            dfs(biTree, right, sum);
        }
    }
}