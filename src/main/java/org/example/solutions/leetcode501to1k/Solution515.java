package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution515 {
    class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Queue<TreeNode> qu = new ArrayDeque<>();
            qu.offer(root);
            while (!qu.isEmpty()) {
                int mx = Integer.MIN_VALUE;
                int m = qu.size();
                for (int i = 0; i < m; i++) {
                    var node = qu.poll();
                    mx = Math.max(mx, node.val);
                    if (node.left != null) {
                        qu.offer(node.left);
                    }
                    if (node.right != null) {
                        qu.offer(node.right);
                    }
                }
                ans.add(mx);
            }
            return ans;
        }
    }
}