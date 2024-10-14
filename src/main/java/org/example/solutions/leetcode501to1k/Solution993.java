package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution993 {
    class Solution {
        public boolean isCousins(TreeNode root, int x, int y) {
            Queue<TreeNode> qu = new LinkedList<>();
            qu.offer(root);
            while (!qu.isEmpty()) {
                int m = qu.size();
                boolean vis1 = false;
                int parent = -1;
                for (int i = 0; i < m; i++) {
                    TreeNode node = qu.poll();
                    if (node.left != null) {
                        int n = node.left.val;
                        if (n == x || n == y) {
                            if (vis1) {
                                return parent != node.val;
                            }
                            vis1 = true;
                            parent = node.val;
                        }
                        qu.offer(node.left);
                    }
                    if (node.right != null) {
                        int n = node.right.val;
                        if (n == x || n == y) {
                            if (vis1) {
                                return parent != node.val;
                            }
                            vis1 = true;
                            parent = node.val;
                        }
                        qu.offer(node.right);
                    }
                }
                if (vis1) {
                    return false;
                }
            }
            return true;
        }
    }
}