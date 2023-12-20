package org.example.solutions.leetcode1to200;

import org.example.utils.Node;

import java.util.*;

public class Solution116 {
    class Solution {
        public Node connect(Node root) {
            if (root == null) {
                return null;
            }
            Queue<Node> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int n = queue.size();
                for (int i = 0; i < n; i++) {
                    Node t = queue.poll();
                    if (t.left != null) {
                        queue.offer(t.left);
                    }
                    if (t.right != null) {
                        queue.offer(t.right);
                    }
                    if (i != n - 1) t.next = queue.peek();
                }
            }
            return root;
        }
    }
}