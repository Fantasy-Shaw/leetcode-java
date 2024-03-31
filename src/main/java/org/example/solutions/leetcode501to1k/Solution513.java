package org.example.solutions.leetcode501to1k;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution513 {
    class Solution {
        public int findBottomLeftValue(TreeNode root) {
            int ans = -1;
            Queue<TreeNode> qu = new ArrayDeque<>();
            qu.offer(root);
            while (!qu.isEmpty()) {
                int m = qu.size();
                for (int i = 0; i < m; i++) {
                    var node = qu.poll();
                    if (i == 0) ans = node.val;
                    if (node.left != null) {
                        qu.offer(node.left);
                    }
                    if (node.right != null) {
                        qu.offer(node.right);
                    }
                }
            }
            return ans;
        }
    }
}