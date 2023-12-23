package org.example.solutions.leetcode1kto2k;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution1373 {
    class Solution {
        private int ans;

        public int maxSumBST(TreeNode root) {
            ans = 0;
            dfs(root);
            return ans;
        }

        private Node dfs(TreeNode root) {
            if (root == null) {
                return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }
            Node lNode = dfs(root.left), rNode = dfs(root.right);
            int x = root.val;
            if (x <= lNode.r || x >= rNode.l) {
                return new Node(Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
            }
            int sum = lNode.sum + rNode.sum + x;
            ans = Math.max(ans, sum);
            return new Node(Math.min(x, lNode.l), Math.max(x, rNode.r), sum);
        }

        private static class Node {
            // values in [l, r]
            public int l, r, sum;

            public Node(int l, int r, int sum) {
                this.l = l;
                this.r = r;
                this.sum = sum;
            }
        }
    }
}