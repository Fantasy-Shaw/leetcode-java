package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution105 {
    class Solution {
        HashMap<Integer, Integer> indices;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            indices = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                indices.put(inorder[i], i);
            }
            return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
        }

        private TreeNode dfs(int[] preorder, int l, int r, int[] inorder, int i, int j) {
            if (l > r || i > j) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[l]);
            int mid = indices.get(preorder[l]); // find root
            int size = mid - i; // left subtree
            root.left = dfs(preorder, l + 1, l + size, inorder, i, mid - 1);
            root.right = dfs(preorder, l + size + 1, r, inorder, mid + 1, j);
            return root;
        }
    }
}