package org.example.solutions;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution545 {
    private class Solution {
        public List<Integer> boundaryOfBinaryTree(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            if (!isLeaf(root)) {
                res.add(root.val);
            }
            TreeNode t = root.left;
            while (t != null) {
                if (!isLeaf(t)) {
                    res.add(t.val);
                }
                if (t.left != null) {
                    t = t.left;
                } else {
                    t = t.right;
                }
            }
            addLeaves(res, root);
            Stack<Integer> st = new Stack<>();
            t = root.right;
            while (t != null) {
                if (!isLeaf(t)) {
                    st.push(t.val);
                }
                if (t.right != null) {
                    t = t.right;
                } else {
                    t = t.left;
                }
            }
            while (!st.isEmpty()) {
                res.add(st.pop());
            }
            return res;
        }

        private boolean isLeaf(TreeNode t) {
            return t.left == null && t.right == null;
        }

        private void addLeaves(List<Integer> res, TreeNode root) {
            if (isLeaf(root)) {
                res.add(root.val);
            } else {
                if (root.left != null) {
                    addLeaves(res, root.left);
                }
                if (root.right != null) {
                    addLeaves(res, root.right);
                }
            }
        }
    }
}