package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    class Solution {
        private int targetSum;
        private List<List<Integer>> ans;

        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            this.targetSum = targetSum;
            ans = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            backTrack(root, path, 0);
            return ans;
        }

        private void backTrack(TreeNode node, List<Integer> path, int cur) {
            if (node == null) {
                return;
            }
            path.add(node.val);
            cur += node.val;
            if (node.left == null && node.right == null) {
                if (cur == targetSum) {
                    ans.add(new ArrayList<>(path));
                }
            }
            backTrack(node.left, path, cur);
            backTrack(node.right, path, cur);
            path.remove(path.size() - 1);
        }
    }
}