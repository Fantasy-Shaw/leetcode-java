package org.example.solutions.leetcode501to1k;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution501 {
    class Solution {
        private List<Integer> nodes;

        public int[] findMode(TreeNode root) {
            nodes = new ArrayList<>();
            inOrder(root);
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(value -> -value[1]));
            int i = 0, j = 0;
            while (i < nodes.size()) {
                while (j < nodes.size() && Objects.equals(nodes.get(j), nodes.get(i))) {
                    j++;
                }
                pq.add(new int[]{nodes.get(i), j - i - 1});
                i = j;
            }
            List<int[]> ans = new ArrayList<>();
            ans.add(pq.poll());
            while (!pq.isEmpty() && pq.peek()[1] == ans.getLast()[1]) {
                ans.add(pq.poll());
            }
            return ans.stream().mapToInt(value -> value[0]).toArray();
        }

        private void inOrder(TreeNode root) {
            if (root == null) return;
            inOrder(root.left);
            nodes.add(root.val);
            inOrder(root.right);
        }
    }
}