package org.example.solutions.leetcode200to1k;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution272 {
    private class Solution {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            Queue<Integer> q = new ArrayDeque<>();
            inOrder(q, root, target, k);
            return new ArrayList<>(q);
        }

        // BST - Inorder - min->max
        private void inOrder(Queue<Integer> q, TreeNode root, double target, int k) {
            if (root == null) {
                return;
            }
            inOrder(q, root.left, target, k);
            if (q.size() == k) {
                double t1 = Math.abs(q.peek() - target);
                double t2 = Math.abs(root.val - target);
                if (t1 - t2 > 0) {
                    q.poll();
                    q.offer(root.val);
                } else {
                    return;
                }
            } else {
                q.offer(root.val);
            }
            inOrder(q, root.right, target, k);
        }
    }

}