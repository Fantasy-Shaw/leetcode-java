package org.example.solutions.leetcode2k;

import org.example.templates.BinarySearch;
import org.example.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution2476 {
    class Solution {
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            List<List<Integer>> ans = new ArrayList<>();
            for (var q : queries) {
                int mn = BinarySearch.upperBound(list, q) - 1;
                int mx = BinarySearch.lowerBound(list, q);
                ans.add(List.of(
                        mn == -1 ? -1 : list.get(mn),
                        mx == list.size() ? -1 : list.get(mx)
                ));
            }
            return ans;
        }

        private void inorder(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }
}