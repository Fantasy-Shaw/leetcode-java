package org.example.solutions.leetcode1kto2k;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution1676 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
            Set<TreeNode> set = new HashSet<>(Arrays.asList(nodes));
            return dfs(root, set);
        }

        private TreeNode dfs(TreeNode root, Set<TreeNode> nodes) {
            if (root == null || nodes.contains(root)) {
                return root;
            }
            var left = dfs(root.left, nodes);
            var right = dfs(root.right, nodes);
            if (left != null && right != null) {
                return root;
            }
            return left == null ? right : left;
        }
    }
}