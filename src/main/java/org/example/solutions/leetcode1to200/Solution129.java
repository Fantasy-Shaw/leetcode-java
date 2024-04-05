package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution129 {
    class Solution {
        public int sumNumbers(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            dfs(nums, root, 0);
            int ans = 0;
            for (var x : nums) {
                ans += x;
            }
            return ans;
        }

        private void dfs(List<Integer> nums, TreeNode root, int cur) {
            if (root == null) return;
            cur = cur * 10 + root.val;
            if (root.left == null && root.right == null) {
                nums.add(cur);
                return;
            }
            dfs(nums, root.left, cur);
            dfs(nums, root.right, cur);
        }
    }
}