package org.example.solutions.leetcode1kto2k;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution1261 {
    class FindElements {
        Set<Integer> set;

        public FindElements(TreeNode root) {
            set = new HashSet<>();
            root.val = 0;
            Queue<TreeNode> qu = new LinkedList<>();
            qu.offer(root);
            while (!qu.isEmpty()) {
                int m = qu.size();
                for (int i = 0; i < m; i++) {
                    var node = qu.poll();
                    set.add(node.val);
                    if (node.left != null) {
                        node.left.val = 2 * node.val + 1;
                        qu.offer(node.left);
                    }
                    if (node.right != null) {
                        node.right.val = 2 * node.val + 2;
                        qu.offer(node.right);
                    }
                }
            }
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }
}