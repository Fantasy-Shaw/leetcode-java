package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution144 {
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }
            Deque<TreeNode> st = new ArrayDeque<>();
            TreeNode prev = null;
            while (root != null || !st.isEmpty()) {
                while (root != null) {
                    st.push(root);
                    root = root.left;
                }
                root = st.pop();
                if (root.right == null || root.right == prev) {
                    ans.add(root.val);
                    prev = root;
                    root = null;
                } else {
                    st.push(root);
                    root = root.right;
                }
            }
            return ans;
        }
    }
}