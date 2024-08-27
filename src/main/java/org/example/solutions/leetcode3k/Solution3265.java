package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3265 {
    class Solution {
        public int countPairs(int[] nums) {
            int ans = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (isValid(nums[i], nums[j])) {
                        ans++;
                    }
                }
            }
            return ans;
        }

        private static boolean isValid(int x1, int x2) {
            if (x1 == x2) {
                return true;
            }
            String str1 = String.valueOf(Math.max(x1, x2));
            String str2 = String.valueOf(Math.min(x1, x2));
            str2 = "0".repeat(str1.length() - str2.length()) + str2;
            char[] s1 = str1.toCharArray();
            char[] s2 = str2.toCharArray();
            int n = s1.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    swap(s1, i, j);
                    if (Arrays.equals(s1, s2)) {
                        return true;
                    }
                    swap(s1, i, j);
                }
            }
            return false;
        }

        private static void swap(char[] arr, int i, int j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}