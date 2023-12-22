package org.example.solutions.leetcode1kto2k;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution1214 {
    class Solution {
        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
            inOrder(root1, list1);
            inOrder(root2, list2);
            int m = list1.size(), n = list2.size();
            for (int i = 0; i < m; i++) {
                int cur1 = list1.get(i);
                if (cur1 + list2.get(n - 1) < target) {
                    continue;
                }
                int l = 0, r = n - 1;
                int mid = (l + r) / 2;
                while (l < r) {
                    int cur2 = list2.get(mid);
                    if (cur1 + cur2 < target) l = mid + 1;
                    else if (cur1 + cur2 >= target) r = mid;
                    mid = (l + r) / 2;
                }
                int cur2 = list2.get(mid);
                if (cur1 + cur2 == target) return true;
//            for (int j = 0; j < n; j++) {
//                int cur2 = list2.get(j);
//                if (cur1 + cur2 < target) continue;
//                else if (cur1 + cur2 == target) return true;
//                else break;
//            }
            }
            return false;
        }

        private void inOrder(TreeNode root, List<Integer> list) {
            if (root == null) return;
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}