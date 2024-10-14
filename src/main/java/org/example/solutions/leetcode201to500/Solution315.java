package org.example.solutions.leetcode201to500;

import java.util.ArrayList;
import java.util.List;

public class Solution315 {
    class Solution {
        int[] tmp, indices, tmpIndices, ans;

        public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
            tmp = new int[n];
            indices = new int[n];
            tmpIndices = new int[n];
            ans = new int[n];
            for (int i = 0; i < n; i++) {
                indices[i] = i;
            }
            mergeSort(nums, 0, n - 1);
            List<Integer> ans = new ArrayList<>();
            for (int i : this.ans) {
                ans.add(i);
            }
            return ans;
        }

        private void mergeSort(int[] arr, int l, int r) {
            if (l >= r) {
                return;
            }
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            int i = l, j = mid + 1, p = l;
            while (i <= mid || j <= r) {
                if (i == mid + 1) {
                    tmp[p] = arr[j];
                    tmpIndices[p] = indices[j];
                    p++;
                    j++;
                } else if (j == r + 1 || arr[i] <= arr[j]) {
                    tmp[p] = arr[i];
                    tmpIndices[p] = indices[i];
                    ans[indices[i]] += (j - mid - 1);
                    p++;
                    i++;
                } else {
                    tmp[p] = arr[j];
                    tmpIndices[p] = indices[j];
                    p++;
                    j++;
                }
            }
            for (int k = l; k <= r; k++) {
                indices[k] = tmpIndices[k];
                arr[k] = tmp[k];
            }
        }
    }
}