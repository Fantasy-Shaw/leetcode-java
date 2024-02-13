package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution987 {
    class Solution {
        public List<List<Integer>> verticalTraversal(TreeNode root) {
            // int[3]: [row,col,node.val]
            List<int[]> nodeList = new ArrayList<>();
            dfs(nodeList, root, 0, 0);
            nodeList.sort((a, b) -> {
                return a[1] != b[1] ? a[1] - b[1] : (a[0] != b[0] ? a[0] - b[0] : a[2] - b[2]);
            });
            int preCol = nodeList.getFirst()[1];
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> cur = new ArrayList<>();
            cur.add(nodeList.getFirst()[2]);
            for (int i = 1; i < nodeList.size(); i++) {
                int[] curNode = nodeList.get(i);
                if (curNode[1] != preCol) {
                    ans.add(new ArrayList<>(cur));
                    cur.clear();
                }
                preCol = curNode[1];
                cur.add(curNode[2]);
            }
            ans.add(new ArrayList<>(cur));
            return ans;
        }

        private void dfs(List<int[]> nodeList, TreeNode node, int row, int col) {
            if (node == null) {
                return;
            }
            nodeList.add(new int[]{row, col, node.val});
            dfs(nodeList, node.left, row + 1, col - 1);
            dfs(nodeList, node.right, row + 1, col + 1);
        }
    }
}