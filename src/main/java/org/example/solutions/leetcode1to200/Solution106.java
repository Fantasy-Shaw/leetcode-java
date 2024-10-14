package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

import java.util.HashMap;

public class Solution106 {
    class Solution {
        HashMap<Integer, Integer> indices;

        public TreeNode buildTree(int[] inorder, int[] postorder) {
            indices = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                indices.put(inorder[i], i);
            }
            return dfs(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode dfs(int[] inorder, int i, int j, int[] postorder, int l, int r) {
            if (i > j || l > r) {
                return null;
            }
            TreeNode root = new TreeNode(postorder[r]);
            int mid = indices.get(postorder[r]);
            int size = j - mid; // right subtree
            root.left = dfs(inorder, i, mid - 1, postorder, l, r - size - 1);
            root.right = dfs(inorder, mid + 1, j, postorder, r - size, r - 1);
            return root;
        }
    }
}