package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution958 {
    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> qu = new ArrayDeque<>();
            qu.offer(root);
            while (!qu.isEmpty()) {
                int m = qu.size();
                List<Integer> cur = new ArrayList<>();
                boolean visNull = false;
                for (int i = 0; i < m; i++) {
                    var node = qu.poll();
                    cur.add(node.val);
                    if (node.left != null) {
                        if (visNull) return false;
                        qu.offer(node.left);
                    } else {
                        visNull = true;
                    }
                    if (node.right != null) {
                        if (visNull) return false;
                        qu.offer(node.right);
                    } else {
                        visNull = true;
                    }
                }
                ans.add(cur);
            }
            int n = 1;
            for (int i = 0; i < ans.size() - 1; i++) {
                if (ans.get(i).size() != n) {
                    return false;
                }
                n *= 2;
            }
            return true;
        }
    }
}