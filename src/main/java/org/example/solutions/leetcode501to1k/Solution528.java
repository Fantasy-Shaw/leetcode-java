package org.example.solutions.leetcode501to1k;

import org.example.templates.BinarySearch;

import java.util.*;

public class Solution528 {
    class Solution {
        int[] sum;
        Random random;

        public Solution(int[] w) {
            sum = new int[w.length + 1];
            for (int i = 0; i < w.length; i++) {
                sum[i + 1] = sum[i] + w[i];
            }
            random = new Random();
        }

        public int pickIndex() {
            int x = random.nextInt(sum[sum.length - 1]);
            return BinarySearch.upperBound(sum, x) - 1;
        }
    }
}