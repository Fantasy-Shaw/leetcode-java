package org.example.solutions.leetcode501to1k;


import java.util.Arrays;
import java.util.Comparator;

public class Solution506 {
    static
    class Solution {
        public String[] findRelativeRanks(int[] score) {
            int n = score.length;
            int[][] sc = new int[n][2];
            for (int i = 0; i < n; i++) {
                sc[i][0] = score[i];
                sc[i][1] = i;
            }
            Arrays.sort(sc, Comparator.comparingInt(a -> -a[0]));
            String[] ranks = new String[n];
            for (int i = 3; i < n; i++) {
                ranks[sc[i][1]] = String.valueOf(i + 1);
            }
            ranks[sc[0][1]] = "Gold Medal";
            if (n >= 2) {
                ranks[sc[1][1]] = "Silver Medal";
            }
            if (n >= 3) {
                ranks[sc[2][1]] = "Bronze Medal";
            }
            return ranks;
        }
    }
}