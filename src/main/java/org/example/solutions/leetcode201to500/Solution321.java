package org.example.solutions.leetcode201to500;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution321 {
    class Solution {
        public int[] maxNumber(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            int[] ans = null;
            for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
                int[] sub1 = mxSubSeq(nums1, i), sub2 = mxSubSeq(nums2, k - i);
                int[] cur = merge(sub1, sub2);
                if (ans == null || cmpIntAsArr(cur, ans) > 0) {
                    ans = cur;
                }
            }
            return ans;
        }

        private int[] mxSubSeq(int[] nums, int k) {
            Deque<Integer> monoSt = new ArrayDeque<>();
            int remain = nums.length - k;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                while (!monoSt.isEmpty() && monoSt.peekLast() < num && remain > 0) {
                    monoSt.pollLast();
                    remain--;
                }
                if (monoSt.size() < k) {
                    monoSt.offerLast(num);
                } else {
                    remain--;
                }
            }
            return monoSt.stream().mapToInt(i -> i).toArray();
        }

        private int cmpIntAsArr(int[] arr1, int[] arr2) {
            return cmpIntAsArr(arr1, 0, arr2, 0);
        }

        private int cmpIntAsArr(int[] arr1, int i, int[] arr2, int j) {
            int m = arr1.length, n = arr2.length;
            while (i < m && j < n) {
                int t = arr1[i] - arr2[j];
                if (t != 0) {
                    return t;
                }
                i++;
                j++;
            }
            return (m - i) - (n - j);
        }

        private int[] merge(int[] arr1, int[] arr2) {
            int m = arr1.length, n = arr2.length;
            if (m == 0) return arr2;
            if (n == 0) return arr1;
            int[] ans = new int[m + n];
            int i = 0, j = 0;
            for (int x = 0; x < ans.length; x++) {
                ans[x] = cmpIntAsArr(arr1, i, arr2, j) > 0 ? arr1[i++] : arr2[j++];
            }
            return ans;
        }
    }
}