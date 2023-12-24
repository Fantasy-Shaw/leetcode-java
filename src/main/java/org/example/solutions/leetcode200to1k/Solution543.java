package org.example.solutions.leetcode200to1k;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution543 {
    class Solution {
        private int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            ans = 1;
            depth(root);
            return ans - 1;
        }

        private int depth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int l = depth(root.left), r = depth(root.right);
            ans = Math.max(ans, l + r + 1);
            return Math.max(l, r) + 1;
        }
    }
}