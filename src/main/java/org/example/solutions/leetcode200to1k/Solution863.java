package org.example.solutions.leetcode200to1k;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution863 {
    class Solution {
        Map<Integer, List<Integer>> graph;
        boolean[] vis;
        List<Integer> ans;
        int k;

        public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
            this.k = k;
            graph = new HashMap<>();
            Queue<TreeNode> qu = new ArrayDeque<>();
            qu.offer(root);
            while (!qu.isEmpty()) {
                int m = qu.size();
                for (int i = 0; i < m; i++) {
                    var node = qu.poll();
                    checkMap(graph, node, node.left, node.right);
                    if (node.left != null) {
                        qu.offer(node.left);
                        graph.get(node.val).add(node.left.val);
                        graph.get(node.left.val).add(node.val);
                    }
                    if (node.right != null) {
                        qu.offer(node.right);
                        graph.get(node.val).add(node.right.val);
                        graph.get(node.right.val).add(node.val);
                    }
                }
            }
            ans = new ArrayList<>();
            vis = new boolean[505];
            dfs(target.val, 0);
            return ans;
        }

        private void dfs(int val, int cur) {
            if (vis[val] || cur > k) return;
            if (cur == k) {
                ans.add(val);
            }
            vis[val] = true;
            for (int nb : graph.get(val)) {
                dfs(nb, cur + 1);
            }
        }

        private static void checkMap(Map<Integer, List<Integer>> graph, TreeNode... nodes) {
            for (var n : nodes) {
                if (n != null) {
                    graph.putIfAbsent(n.val, new ArrayList<>());
                }
            }
        }
    }
}