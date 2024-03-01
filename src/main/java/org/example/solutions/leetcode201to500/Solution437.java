package org.example.solutions.leetcode201to500;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution437 {
    class Solution {
        public int pathSum(TreeNode root, int targetSum) {
            Map<Long, Integer> prefix = new HashMap<>();
            prefix.put(0L, 1);
            return (int) dfs(root, prefix, 0, targetSum);
        }

        private long dfs(TreeNode root, Map<Long, Integer> prefix, long cur, int target) {
            // preorder
            if (root == null) {
                return 0;
            }
            cur += root.val;
            long ans = prefix.getOrDefault(cur - target, 0);
            prefix.put(cur, prefix.getOrDefault(cur, 0) + 1);
            ans += dfs(root.left, prefix, cur, target);
            ans += dfs(root.right, prefix, cur, target);
            prefix.put(cur, prefix.get(cur) - 1);
            return ans;
        }
    }
}