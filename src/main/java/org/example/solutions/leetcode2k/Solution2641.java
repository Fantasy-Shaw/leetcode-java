package org.example.solutions.leetcode2k;

import org.example.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution2641 {
    class Solution {
        public TreeNode replaceValueInTree(TreeNode root) {
            Queue<TreeNode> qu1 = new ArrayDeque<>(), qu2 = new ArrayDeque<>();
            qu1.offer(root);
            root.val = 0;
            while (!qu1.isEmpty()) {
                int size = qu1.size();
                int sum = 0;
                for (int i = 0; i < size; i++) {
                    TreeNode node = qu1.poll();
                    qu2.offer(node);
                    if (node.left != null) {
                        sum += node.left.val;
                        qu1.offer(node.left);
                    }
                    if (node.right != null) {
                        sum += node.right.val;
                        qu1.offer(node.right);
                    }
                }
                while (!qu2.isEmpty()) {
                    TreeNode node = qu2.poll();
                    int cur = sum;
                    if (node.left != null) {
                        cur -= node.left.val;
                    }
                    if (node.right != null) {
                        cur -= node.right.val;
                    }
                    if (node.left != null) {
                        node.left.val = cur;
                    }
                    if (node.right != null) {
                        node.right.val = cur;
                    }
                }
            }
            return root;
        }
    }
}