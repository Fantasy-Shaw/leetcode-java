package org.example.solutions.leetcode1to200;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution124 {
    class Solution {
        private int maxPath;

        public int maxPathSum(TreeNode root) {
            maxPath = -0x3f3f3f3f;
            treeMax(root);
            return maxPath;
        }

        private int treeMax(TreeNode node) {
            if (node == null) {
                return 0;
            }
            int lmx = Math.max(treeMax(node.left), 0);
            int rmx = Math.max(treeMax(node.right), 0);
            int curMax = node.val + lmx + rmx;
            maxPath = Math.max(maxPath, curMax);
            return node.val + Math.max(lmx, rmx);
        }
    }
}