package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

public class Solution156 {
    class Solution {
        public TreeNode upsideDownBinaryTree(TreeNode root) {
            TreeNode parent = null, rightChild = null;
            while (root != null) {
                TreeNode leftChild = root.left;
                root.left = rightChild;
                rightChild = root.right;
                root.right = parent;
                parent = root;
                root = leftChild;
            }
            return parent;
        }
    }
}