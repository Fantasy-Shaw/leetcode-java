package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution103 {
    class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            boolean isRev = false;
            Queue<TreeNode> qu = new ArrayDeque<>();
            qu.offer(root);
            while (!qu.isEmpty()) {
                int m = qu.size();
                List<Integer> cur = new ArrayList<>();
                if (!isRev) {
                    for (int i = 0; i < m; i++) {
                        var node = qu.poll();
                        if (node.left != null) {
                            qu.offer(node.left);
                        }
                        if (node.right != null) {
                            qu.offer(node.right);
                        }
                        cur.add(node.val);
                    }
                } else {
                    Deque<Integer> st = new ArrayDeque<>();
                    for (int i = 0; i < m; i++) {
                        var node = qu.poll();
                        if (node.left != null) {
                            qu.offer(node.left);
                        }
                        if (node.right != null) {
                            qu.offer(node.right);
                        }
                        st.push(node.val);
                    }
                    while (!st.isEmpty()) {
                        cur.add(st.pop());
                    }
                }
                ans.add(cur);
                isRev = !isRev;
            }
            return ans;
        }
    }
}