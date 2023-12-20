package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution107 {
    private class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Stack<List<Integer>> stack = new Stack<>();
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                List<Integer> cur = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                    cur.add(node.val);
                }
                stack.add(cur);
            }
            while (!stack.isEmpty()) {
                ans.add(stack.pop());
            }
            return ans;
        }
    }
}