package org.example.solutions.leetcode201to500;

import java.util.Arrays;

public class Solution324 {
    static
    class Solution {
        public void wiggleSort(int[] nums) {
            int n = nums.length;
            int l = n / 2;
            int s = n - l;
            int[] arr = nums.clone();
            Arrays.sort(arr);
            int[] idx = new int[]{s - 1, n - 1};
            int cur = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = arr[idx[cur]--];
                cur ^= 1;
            }
        }
    }
}