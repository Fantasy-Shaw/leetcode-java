package org.example.solutions.leetcode1kto2k;

import org.example.utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class Solution1028 {
    class Solution {
        public TreeNode recoverFromPreorder(String traversal) {
            List<int[]> list = new LinkedList<>();
            int n = traversal.length();
            for (int i = 0; i < n; ) {
                int j = i;
                while (j < n && traversal.charAt(j) == '-') {
                    j++;
                }
                int k = j;
                while (k < n && Character.isDigit(traversal.charAt(k))) {
                    k++;
                }
                list.add(new int[]{Integer.parseInt(traversal.substring(j, k)), j - i});
                i = k;
            }
            return dfs(list, 0);
        }

        private TreeNode dfs(List<int[]> list, int level) {
            if (list.isEmpty() || level != list.getFirst()[1]) {
                return null;
            }
            TreeNode root = new TreeNode(list.removeFirst()[0]);
            root.left = dfs(list, level + 1);
            root.right = dfs(list, level + 1);
            return root;
        }
    }
}