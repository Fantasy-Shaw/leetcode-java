package org.example.solutions.LCR;

import org.example.templates.Fenwick;

import java.util.*;

public class P170 {
    class Solution {
        public int reversePairs(int[] record) {
            int n = record.length;
            TreeSet<Integer> set = new TreeSet<>();
            Arrays.stream(record).forEach(set::add);
            Fenwick fenwick = new Fenwick(n);
            int rank = 1; // fenwick start with idx=1
            Map<Integer, Integer> num2rnk = new HashMap<>();
            for (var x : set) {
                num2rnk.put(x, rank++);
            }
            int ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                int rnk = num2rnk.get(record[i]);
                fenwick.add(rnk, 1);
                ans += fenwick.pre(rnk - 1);
            }
            return ans;
        }
    }

    class Solution1 {
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