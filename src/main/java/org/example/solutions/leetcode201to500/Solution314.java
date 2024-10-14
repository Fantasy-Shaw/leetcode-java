package org.example.solutions.leetcode201to500;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution314 {
    private class Pair<_Tp1, _Tp2> {
        _Tp1 first;
        _Tp2 second;

        Pair(_Tp1 first, _Tp2 second) {
            this.first = first;
            this.second = second;
        }
    }

    private class Solution {
        public List<List<Integer>> verticalOrder(TreeNode root) {
            List<List<Integer>> output = new ArrayList<>();
            if (root == null) {
                return output;
            }
            Map<Integer, List<Integer>> columnTable = new HashMap<>();
            Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
            int column = 0;
            queue.offer(new Pair<>(root, column));
            while (!queue.isEmpty()) {
                var p = queue.poll();
                root = p.first;
                column = p.second;
                if (root != null) {
                    if (!columnTable.containsKey(column)) {
                        columnTable.put(column, new ArrayList<>());
                    }
                    columnTable.get(column).add(root.val);
                    queue.offer(new Pair<>(root.left, column - 1));
                    queue.offer(new Pair<>(root.right, column + 1));
                }
            }
            List<Integer> sortedKeys = new ArrayList<>(columnTable.keySet());
            Collections.sort(sortedKeys);
            for (int k : sortedKeys) {
                output.add(columnTable.get(k));
            }
            return output;
        }
    }
}


