package org.example.solutions.leetcode3k;

public class Solution3152 {
    class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            int n = nums.length;
            int flag = nums[0] % 2 == 0 ? 1 : -1;
            int[] tags = new int[n];
            for (int i = 1; i < nums.length; i++) {
                int cur = nums[i] % 2 == 0 ? 1 : -1;
                if (flag * cur == 1) {
                    tags[i] = i;
                } else {
                    flag = cur;
                    tags[i] = tags[i - 1];
                }
            }
//        System.out.println(Arrays.toString(tags));
            boolean[] ans = new boolean[queries.length];
            for (int i = 0; i < queries.length; i++) {
                ans[i] = tags[queries[i][0]] == tags[queries[i][1]];
            }
            return ans;
        }
    }
}