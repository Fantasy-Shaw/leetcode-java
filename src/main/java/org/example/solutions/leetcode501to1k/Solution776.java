package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

public class Solution776 {
    class Solution {
        public TreeNode[] splitBST(TreeNode root, int target) {
            if (root == null) {
                return new TreeNode[]{null, null};
            }
            if (root.val <= target) {
                var ans = splitBST(root.right, target);
                root.right = ans[0];
                ans[0] = root;
                return ans;
            } else {
                var ans = splitBST(root.left, target);
                root.left = ans[1];
                ans[1] = root;
                return ans;
            }
        }
    }
}