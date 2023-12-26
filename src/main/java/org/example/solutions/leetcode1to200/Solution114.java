package org.example.solutions.leetcode1to200;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution114 {
    class Solution {
        public void flatten(TreeNode root) {
            List<TreeNode> v = new ArrayList<>();
            Deque<TreeNode> stk = new ArrayDeque<>();
            var node = root;
            while (node != null || !stk.isEmpty()) {
                while (node != null) {
                    v.add(node);
                    stk.push(node);
                    node = node.left;
                }
                node = stk.pop();
                node = node.right;
            }
            int size = v.size();
            for (int i = 1; i < size; i++) {
                var prev = v.get(i - 1);
                var cur = v.get(i);
                prev.left = null;
                prev.right = cur;
            }
        }
    }
}