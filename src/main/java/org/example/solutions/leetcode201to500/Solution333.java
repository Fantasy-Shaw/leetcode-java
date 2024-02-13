package org.example.solutions.leetcode201to500;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution333 {
    class Solution {
        private int ans;

        public int largestBSTSubtree(TreeNode root) {
            ans = 0;
            if (root == null) {
                return 0;
            }
            dfs(root);
            return ans;
        }

        private Node dfs(TreeNode root) {
            if (root.left == null && root.right == null) {
                ans = Math.max(ans, 1);
                return new Node(root.val, root.val, 1);
            }
            int size = 1;
            boolean valid = true;
            int l = root.val, r = root.val;
            if (root.left != null) {
                Node lNode = dfs(root.left);
                if (lNode.size != -1 && root.val > lNode.r) {
                    size += lNode.size;
                    l = lNode.l;
                } else {
                    valid = false;
                }
            }
            if (root.right != null) {
                Node rNode = dfs(root.right);
                if (rNode.size != -1 && root.val < rNode.l) {
                    size += rNode.size;
                    r = rNode.r;
                } else {
                    valid = false;
                }
            }
            if (valid) {
                ans = Math.max(ans, size);
                return new Node(l, r, size);
            }
            return new Node(-1, -1, -1);
        }

        private static class Node {
            // values in [l, r]
            public int l, r, size;

            public Node(int l, int r, int size) {
                this.l = l;
                this.r = r;
                this.size = size;
            }
        }
    }
}