package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

import java.util.HashSet;

public class Solution653 {
    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            HashSet<Integer> set = new HashSet<>();
            inorder(set, root);
            for (var x : set) {
                if (set.contains(k - x) && x != k - x) {
                    return true;
                }
            }
            return false;
        }

        private void inorder(HashSet<Integer> set, TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(set, root.left);
            set.add(root.val);
            inorder(set, root.right);
        }
    }
}