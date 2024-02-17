package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution505 {
    class Solution {
        static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int shortestDistance(int[][] maze, int[] start, int[] destination) {
            int m = maze.length, n = maze[0].length;
            int[][] dist = new int[m][n];
            for (int[] row : dist) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            dist[start[0]][start[1]] = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
            pq.offer(new int[]{start[0], start[1], 0});
            while (!pq.isEmpty()) {
                int[] s = pq.poll();
                if (dist[s[0]][s[1]] < s[2]) {
                    continue;
                }
                for (int[] dir : dirs) {
                    int x = s[0] + dir[0];
                    int y = s[1] + dir[1];
                    int count = 0;
                    while (x >= 0 && y >= 0 && x < m && y < n && maze[x][y] == 0) {
                        x += dir[0];
                        y += dir[1];
                        count++;
                    }
                    if (dist[s[0]][s[1]] + count < dist[x - dir[0]][y - dir[1]]) {
                        dist[x - dir[0]][y - dir[1]] = dist[s[0]][s[1]] + count;
                        pq.offer(new int[]{x - dir[0], y - dir[1], dist[x - dir[0]][y - dir[1]]});
                    }
                }
            }
            return dist[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dist[destination[0]][destination[1]];
        }
    }
}