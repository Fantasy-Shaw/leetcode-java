package org.example.solutions.leetcode1kto2k;

public class Solution1064 {
    class Solution {
        public int fixedPoint(int[] arr) {
            int l = 0, r = arr.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (arr[mid] < mid) l = mid + 1;
                else r = mid - 1;
            }
            if (l > arr.length - 1) return -1;
            return arr[l] == l ? l : -1;
        }
    }
}