package org.example.solutions.leetcode501to1k;

import org.example.utils.TreeNode;

import java.util.*;

public class Solution919 {
    class CBTInserter {
        TreeNode root;
        Queue<TreeNode> ins;

        public CBTInserter(TreeNode root) {
            this.root = root;
            Queue<TreeNode> qu = new ArrayDeque<>();
            ins = new ArrayDeque<>();
            qu.offer(root);
            while (!qu.isEmpty()) {
                int m = qu.size();
                for (int i = 0; i < m; i++) {
                    TreeNode cur = qu.poll();
                    if (cur.left == null || cur.right == null) {
                        ins.offer(cur);
                    }
                    if (cur.left != null) {
                        qu.offer(cur.left);
                    }
                    if (cur.right != null) {
                        qu.offer(cur.right);
                    }
                }
            }
        }

        public int insert(int val) {
            TreeNode parent = ins.peek();
            TreeNode node = new TreeNode(val);
            if (parent.left == null) {
                parent.left = node;
                ins.offer(node);
            } else {
                parent.right = node;
                ins.poll();
                ins.offer(node);
            }
            return parent.val;
        }

        public TreeNode get_root() {
            return root;
        }
    }
}