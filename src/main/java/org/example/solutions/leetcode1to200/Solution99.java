package org.example.solutions.leetcode1to200;

import org.example.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution99 {
    class Solution {
        private void inOrder(TreeNode root, List<Integer> nums) {
            if (root == null) return;
            inOrder(root.left, nums);
            nums.add(root.val);
            inOrder(root.right, nums);
        }

        private int[] findSwapped(List<Integer> nums) {
            int n = nums.size();
            int xi = -1, yi = -1;
            for (int i = 0; i < n - 1; i++) {
                if (nums.get(i) > nums.get(i + 1)) {
                    yi = i + 1;
                    if (xi == -1) xi = i;
                    else break;
                }
            }
            return new int[]{nums.get(xi), nums.get(yi)};
        }

        private void recover(TreeNode root, int cnt, int x, int y) {
            if (root == null || cnt == 0) {
                return;
            }
            if (root.val == x || root.val == y) {
                root.val = (root.val == x) ? y : x;
                cnt--;
            }
            recover(root.left, cnt, x, y);
            recover(root.right, cnt, x, y);
        }

        public void recoverTree(TreeNode root) {
            List<Integer> nums = new ArrayList<>();
            inOrder(root, nums);
            int[] swp = findSwapped(nums);
            int x = swp[0], y = swp[1];
            recover(root, 2, x, y);
        }
    }
}