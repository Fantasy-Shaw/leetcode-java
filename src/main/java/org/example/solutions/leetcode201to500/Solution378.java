package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution378 {
    class Solution {
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            PriorityQueue<Pointer> pq = new PriorityQueue<>(Comparator.comparingInt(value -> value.arr[value.idx]));
            for (int[] arr : matrix) {
                pq.offer(new Pointer(arr, 0));
            }
            int ans = 0;
            for (int i = 0; i < k && !pq.isEmpty(); i++) {
                var ptr = pq.poll();
                ans = ptr.arr[ptr.idx];
                if (ptr.idx != n - 1) {
                    pq.offer(new Pointer(ptr.arr, ptr.idx + 1));
                }
            }
            return ans;
        }

        static class Pointer {
            public int[] arr;
            public int idx;

            public Pointer(int[] arr, int idx) {
                this.arr = arr;
                this.idx = idx;
            }
        }
    }
}