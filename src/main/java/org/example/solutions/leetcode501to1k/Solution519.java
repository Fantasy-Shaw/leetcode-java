package org.example.solutions.leetcode501to1k;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution519 {
    class Solution {
        //    private int[][] matrix;
        private int m, n, rest_n;
        private Map<Integer, Integer> map;
        private Random rd;

        public Solution(int m, int n) {
            this.m = m;
            this.n = n;
            rest_n = m * n;
            map = new HashMap<>();
            rd = new Random();
//        matrix = new int[m][n];
        }

        public int[] flip() {
            int idx = rd.nextInt(rest_n--);
            int cur = map.getOrDefault(idx, idx);
            map.put(idx, map.getOrDefault(rest_n, rest_n));
            int x = cur / n, y = cur % n;
//        matrix[x][y] = 1;
            return new int[]{x, y};
        }

        public void reset() {
            rest_n = m * n;
            map = new HashMap<>();
//        matrix = new int[m][n];
        }
    }
}