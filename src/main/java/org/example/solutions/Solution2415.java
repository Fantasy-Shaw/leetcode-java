package org.example.solutions;

import org.example.utils.TreeNode;

public class Solution2415 {
    private class Solution {
        public TreeNode reverseOddLevels(TreeNode root) {
            helper(root.left, root.right, 1);
            return root;
        }

        private void helper(TreeNode node1, TreeNode node2, int curLv) {
            if (node1 == null || node2 == null) {
                return;
            }
            if (curLv % 2 == 1) {
                var preL = node1.val;
                node1.val = node2.val;
                node2.val = preL;
            }
            helper(node1.left, node2.right, curLv + 1);
            helper(node1.right, node2.left, curLv + 1);
        }
    }
}
