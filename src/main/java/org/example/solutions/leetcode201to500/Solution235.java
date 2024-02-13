package org.example.solutions.leetcode201to500;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution235 {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode ans = root;
            while (true) {
                if (p.val < ans.val && q.val < ans.val) {
                    ans = ans.left;
                } else if (p.val > ans.val && q.val > ans.val) {
                    ans = ans.right;
                } else {
                    break;
                }
            }
            return ans;
        }
    }

    class Solution1 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            List<TreeNode> path_p = getPath(root, p), path_q = getPath(root, q);
            TreeNode ans = null;
            for (int i = 0; i < path_p.size() && i < path_q.size(); i++) {
                if (path_p.get(i) == path_q.get(i)) ans = path_p.get(i);
                else break;
            }
            return ans;
        }

        private List<TreeNode> getPath(TreeNode root, TreeNode target) {
            List<TreeNode> path = new ArrayList<>();
            TreeNode t = root;
            while (t != target && t != null) {
                path.add(t);
                if (target.val < t.val) {
                    t = t.left;
                } else {
                    t = t.right;
                }
            }
            path.add(t);
            return path;
        }
    }
}