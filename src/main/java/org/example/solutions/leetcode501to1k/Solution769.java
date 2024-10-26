package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution769 {
    static
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int[] arr2 = arr.clone();
            Arrays.sort(arr2);
            int ans = 0;
            for (int i = 0, j; i < arr2.length; ) {
                j = i + 1;
                while (j < arr2.length && !equals(arr, arr2, i, j)) {
                    j++;
                }
                ans++;
                i = j;
            }
            return ans;
        }

        private static boolean equals(int[] arr1, int[] arr2, int i, int j) {
            int n = j - i;
            int[] x = new int[n];
            int[] y = new int[n];
            System.arraycopy(arr1, i, x, 0, n);
            System.arraycopy(arr2, i, y, 0, n);
            Arrays.sort(x);
            Arrays.sort(y);
            return Arrays.equals(x, y);
        }
    }
}