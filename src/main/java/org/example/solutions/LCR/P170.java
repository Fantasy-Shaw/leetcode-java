package org.example.solutions.LCR;

public class P170 {
    class Solution {
        int[] tmp;

        public int reversePairs(int[] record) {
            tmp = new int[record.length];
            return mergeSort(record, 0, record.length - 1);
        }

        private int mergeSort(int[] record, int l, int r) {
            if (l >= r) {
                return 0;
            }
            int mid = (l + r) / 2;
            int ans = mergeSort(record, l, mid) + mergeSort(record, mid + 1, r);
            int i = l, j = mid + 1;
            for (int k = l; k <= r; k++) {
                tmp[k] = record[k];
            }
            for (int k = l; k <= r; k++) {
                if (i == mid + 1) {
                    record[k] = tmp[j++];
                } else if (j == r + 1 || tmp[i] <= tmp[j]) {
                    record[k] = tmp[i++];
                } else {
                    record[k] = tmp[j++];
                    ans += (mid - i + 1);
                }
            }
            return ans;
        }
    }
}