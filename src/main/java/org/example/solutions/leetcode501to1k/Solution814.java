package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

public class Solution814 {
    class Solution {
        static final int left = -1, right = 1;

        public TreeNode pruneTree(TreeNode root) {
            dfs(root.left, root, left);
            dfs(root.right, root, right);
            if (root.val == 0 && root.left == null && root.right == null) {
                return null;
            }
            return root;
        }

        private void dfs(TreeNode node, TreeNode parent, int lr) {
            if (node == null) {
                return;
            }
            dfs(node.left, node, left);
            dfs(node.right, node, right);
            if (node.left == null && node.right == null && node.val == 0 && parent != null) {
                if (lr == left) {
                    parent.left = null;
                } else if (lr == right) {
                    parent.right = null;
                }
            }
        }
    }
}