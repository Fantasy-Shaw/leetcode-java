package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1631 {
    private final int N = 10009;
    private int[] p = new int[N];
    private int row, col;

    private int getIdx(int x, int y) {
        return x * col + y;
    }

    private int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    private void union(int a, int b) {
        p[find(a)] = p[find(b)];
    }

    private boolean query(int a, int b) {
        return p[find(a)] == p[find(b)];
    }

    //Kruskal
    public int minimumEffortPath(int[][] heights) {
        row = heights.length;
        col = heights[0].length;
        for (int i = 0; i < row * col; i++) {
            p[i] = i;
        }
        //edge [a,b,w]
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int idx = getIdx(i, j);
                if (i + 1 < row) {
                    int b = getIdx(i + 1, j);
                    int w = Math.abs(heights[i][j] - heights[i + 1][j]);
                    edges.add(new int[]{idx, b, w});
                }
                if (j + 1 < col) {
                    int b = getIdx(i, j + 1);
                    int w = Math.abs(heights[i][j] - heights[i][j + 1]);
                    edges.add(new int[]{idx, b, w});
                }
            }
        }
        edges.sort(Comparator.comparingInt(a -> a[2]));
        int start = getIdx(0, 0), end = getIdx(row - 1, col - 1);
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
            if (query(start, end)) {
                return edge[2];
            }
        }
        return 0;
    }
}