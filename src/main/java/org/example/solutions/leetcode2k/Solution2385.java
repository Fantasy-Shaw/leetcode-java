package org.example.solutions.leetcode2k;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution2385 {
    class Solution {
        public int amountOfTime(TreeNode root, int start) {
            if (root.left == null && root.right == null) {
                return 0;
            }
            List<List<Integer>> graph = new ArrayList<>();
            Queue<TreeNode> qu = new LinkedList<>();
            qu.offer(root);
            add(graph, root);
            while (!qu.isEmpty()) {
                int m = qu.size();
                for (int i = 0; i < m; i++) {
                    TreeNode cur = qu.poll();
                    add(graph, cur);
                    if (cur.left != null) {
                        qu.offer(cur.left);
                    }
                    if (cur.right != null) {
                        qu.offer(cur.right);
                    }
                }
            }
            Queue<Integer> qu2 = new LinkedList<>();
            qu2.offer(start);
            int ans = -1;
            boolean[] vis = new boolean[graph.size()];
            vis[start] = true;
            while (!qu2.isEmpty()) {
                int m = qu2.size();
                for (int i = 0; i < m; i++) {
                    int x = qu2.poll();
                    for (int y : graph.get(x)) {
                        if (!vis[y]) {
                            qu2.offer(y);
                            vis[y] = true;
                        }
                    }
                }
                ans++;
            }
            return ans;
        }

        private void extendTable(List<List<Integer>> graph, int x) {
            while (graph.size() < x + 1) {
                graph.add(new ArrayList<>());
            }
        }

        private void add(List<List<Integer>> graph, TreeNode root) {
            if (root.left != null) {
                extendTable(graph, Math.max(root.val, root.left.val));
                graph.get(root.left.val).add(root.val);
                graph.get(root.val).add(root.left.val);
            }
            if (root.right != null) {
                extendTable(graph, Math.max(root.val, root.right.val));
                graph.get(root.right.val).add(root.val);
                graph.get(root.val).add(root.right.val);
            }
        }
    }
}