package org.example.solutions.leetcode1kto2k;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution1110 {
    class Solution {
        List<TreeNode> ans;
        Set<Integer> del;

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            ans = new ArrayList<>();
            del = new HashSet<>();
            for (int i : to_delete) {
                del.add(i);
            }
            if (dfs(root) != null) {
                ans.add(root);
            }
            return ans;
        }

        private TreeNode dfs(TreeNode node) {
            if (node == null) {
                return null;
            }
            node.left = dfs(node.left);
            node.right = dfs(node.right);
            if (del.contains(node.val)) {
                if (node.left != null) {
                    ans.add(node.left);
                }
                if (node.right != null) {
                    ans.add(node.right);
                }
                return null;
            } else {
                return node;
            }
        }
    }
}