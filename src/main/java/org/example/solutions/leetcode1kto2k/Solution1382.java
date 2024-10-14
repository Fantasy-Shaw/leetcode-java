package org.example.solutions.leetcode1kto2k;

import org.example.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution1382 {
    class Solution {
        private List<Integer> vals;

        public TreeNode balanceBST(TreeNode root) {
            vals = new ArrayList<>();
            inOrder(root);
            return buildBalancedBST(0, vals.size() - 1);
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            vals.add(root.val);
            inOrder(root.right);
        }

        private TreeNode buildBalancedBST(int l, int r) {
            if (l > r) {
                return null;
            }
            int mid = (l + r) / 2;
            TreeNode root = new TreeNode(vals.get(mid));
            root.left = buildBalancedBST(l, mid - 1);
            root.right = buildBalancedBST(mid + 1, r);
            return root;
        }
    }
}