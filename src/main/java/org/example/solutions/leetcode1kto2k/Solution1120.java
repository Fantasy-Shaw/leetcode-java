package org.example.solutions.leetcode1kto2k;

import org.example.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;


class Solution1120 {
    private List<int[]> subTrees;

    public double maximumAverageSubtree(TreeNode root) {
        subTrees = new ArrayList<>();
        dfs(root);
        double ans = -(double) 0x3f3f3f3f * 0x3f3f3f3f;
        for (int[] tr : subTrees) {
            ans = Math.max(ans, (double) (tr[0]) / tr[1]);
        }
        return ans;
    }

    public int[] dfs(TreeNode root) {
        int[] ans = new int[]{root.val, 1};
        if (root.left != null) {
            int[] l = dfs(root.left);
            ans[0] += l[0];
            ans[1] += l[1];
        }
        if (root.right != null) {
            int[] r = dfs(root.right);
            ans[0] += r[0];
            ans[1] += r[1];
        }
        subTrees.add(ans);
        return ans;
    }
}
