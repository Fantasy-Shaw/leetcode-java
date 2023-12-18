package org.example.solutions;

import java.util.*;

import org.example.utils.TreeNode;

public class Solution366 {
    private class Solution {
        private List<int[]> pairs;

        private int getHeight(TreeNode root) {
            if (root == null) {
                return -1;
            }
            int leftHeight = getHeight(root.left);
            int rightHeight = getHeight(root.right);
            int curHeight = Math.max(leftHeight, rightHeight) + 1;
            this.pairs.add(new int[]{curHeight, root.val});
            return curHeight;
        }

        public List<List<Integer>> findLeaves(TreeNode root) {
            this.pairs = new ArrayList<>();
            getHeight(root);
            this.pairs.sort(Comparator.comparing(value -> value[0]));
            int n = this.pairs.size(), height = 0, i = 0;
            List<List<Integer>> ans = new ArrayList<>();
            while (i < n) {
                List<Integer> nums = new ArrayList<>();
                while (i < n && this.pairs.get(i)[0] == height) {
                    nums.add(this.pairs.get(i)[1]);
                    i++;
                }
                ans.add(nums);
                height++;
            }
            return ans;
        }
    }
}