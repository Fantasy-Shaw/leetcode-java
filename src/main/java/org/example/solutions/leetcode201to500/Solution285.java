package org.example.solutions.leetcode201to500;

import org.example.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution285 {
    class Solution {
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            List<TreeNode> list = new ArrayList<>();
            inorder(root, list);
            int k = lowerBound(list, p);
            return k + 1 < list.size() ? list.get(k + 1) : null;
        }

        private void inorder(TreeNode root, List<TreeNode> list) {
            if (root == null) {
                return;
            }
            inorder(root.left, list);
            list.add(root);
            inorder(root.right, list);
        }

        private int lowerBound(List<TreeNode> list, TreeNode p) {
            int l = 0, r = list.size();
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (list.get(mid).val < p.val) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}