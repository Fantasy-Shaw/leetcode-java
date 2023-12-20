package org.example.solutions.leetcode200to1k;

import org.example.utils.TreeNode;

class Solution270 {
    public int closestValue(TreeNode root, double target) {
        if (Math.abs(Math.abs(target - (int) target) - 0.5) < 1e-3) {
            target -= 0.01;
        }
        if (root.val > target && root.left != null) {
            int value = closestValue(root.left, target);
            return Math.abs(value - target) <= Math.abs(root.val - target) ? value : root.val;
        } else if (root.val < target && root.right != null) {
            int value = closestValue(root.right, target);
            return Math.abs(value - target) <= Math.abs(root.val - target) ? value : root.val;
        } else {
            return root.val;
        }
    }
}
