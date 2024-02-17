package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution969 {
    class Solution {
        public List<Integer> pancakeSort(int[] arr) {
            List<Integer> ans = new ArrayList<>();
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                int j = maxElem(arr, 0, n - i);
                ans.add(j + 1);
                reverse(arr, 0, j + 1);
                ans.add(n - i);
                reverse(arr, 0, n - i);
            }
            return ans;
        }

        private void reverse(int[] arr, int l, int r) {
            // [l,r)
            for (int i = 0; i < (r - l) / 2; i++) {
                int t = arr[l + i];
                arr[l + i] = arr[r - i - 1];
                arr[r - i - 1] = t;
            }
        }

        private int maxElem(int[] arr, int l, int r) {
            int ans = l;
            for (int i = l + 1; i < r; i++) {
                if (arr[i] > arr[ans]) {
                    ans = i;
                }
            }
            return ans;
        }
    }
}