package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

import java.util.HashMap;

public class Solution889 {
    class Solution {
        HashMap<Integer, Integer> indices = new HashMap<>();

        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            for (int i = 0; i < postorder.length; i++) {
                indices.put(postorder[i], i);
            }
            return dfs(preorder, 0, preorder.length - 1, postorder, 0, postorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int l, int r, int[] postorder, int i, int j) {
            if (l > r || i > j) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[l]);
            if (l < r) {
                int rootL = indices.get(preorder[l + 1]);
                int size = rootL - i + 1;
                root.left = dfs(preorder, l + 1, l + size, postorder, i, i + size - 1);
                root.right = dfs(preorder, l + size + 1, r, postorder, i + size, j - 1);
            }
            return root;
        }
    }
}