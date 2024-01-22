package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1094 {
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) { // 差分数组
            int[] diff = new int[1001];
            for (int[] t : trips) {
                diff[t[1]] += t[0];
                diff[t[2]] -= t[0];
            }
            int sum = 0;
            for (int i : diff) {
                sum += i;
                if (sum > capacity) {
                    return false;
                }
            }
            return true;
        }
    }
}