package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution145 {
    class Solution {
        private List<Integer> ans;

        public List<Integer> postorderTraversal(TreeNode root) {
            ans = new ArrayList<>();
            if (root != null) {
                postOrder(root);
            }
            return ans;
        }

        private void postOrder(TreeNode root) {
            if (root.left != null) {
                postOrder(root.left);
            }
            if (root.right != null) {
                postOrder(root.right);
            }
            ans.add(root.val);
        }
    }
}
