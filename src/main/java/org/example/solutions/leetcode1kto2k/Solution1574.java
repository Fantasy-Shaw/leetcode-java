package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1574 {
    class Solution {
        public int findLengthOfShortestSubarray(int[] arr) {
            int n = arr.length;
            int right = n - 1;
            while (right > 0 && arr[right - 1] <= arr[right]) {
                right--;
            }
            if (right == 0) {
                return 0;
            }
            int ans = right; // delete [0,right)
            for (int left = 0; left == 0 || arr[left - 1] <= arr[left]; left++) {
                while (right < n && arr[left] > arr[right]) {
                    right++;
                }
                ans = Math.min(ans, right - left - 1); // delete (left,right)
            }
            return ans;
        }
    }
}