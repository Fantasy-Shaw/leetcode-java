package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution199 {
    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> qu = new ArrayDeque<>();
            qu.offer(root);
            while (!qu.isEmpty()) {
                int last = 0, m = qu.size();
                for (int i = 0; i < m; i++) {
                    var node = qu.poll();
                    last = node.val;
                    if (node.left != null) {
                        qu.offer(node.left);
                    }
                    if (node.right != null) {
                        qu.offer(node.right);
                    }
                }
                ans.add(last);
            }
            return ans;
        }
    }
}
