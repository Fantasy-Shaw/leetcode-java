package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1566 {
    class Solution {
        public boolean containsPattern(int[] arr, int m, int k) {
            int n = arr.length;
            for (int i = 0; i <= n - m * k; i++) {
                int j;
                for (j = 0; j < m * k; j++) {
                    if (arr[i + j] != arr[i + j % m]) {
                        break;
                    }
                }
                if (j == m * k) return true;
            }
            return false;
        }
    }
}