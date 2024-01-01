package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1197 {
    class Solution {
        private static final int[][] dirs = {
                {1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}
        };
        private boolean[][] vis;

        public int minKnightMoves(int x, int y) {
            vis = new boolean[605][605];
            Queue<int[]> qu = new ArrayDeque<>();
            qu.offer(new int[]{0, 0});
            int steps = 0;
            while (!qu.isEmpty()) {
                int curSize = qu.size();
                for (int i = 0; i < curSize; i++) {
                    var cur = qu.poll();
                    if (cur[0] == x && cur[1] == y) {
                        return steps;
                    }
                    for (var dir : dirs) {
                        int a = cur[0] + dir[0];
                        int b = cur[1] + dir[1];
                        if (!isVisited(a, b)) {
                            visit(a, b);
                            qu.offer(new int[]{a, b});
                        }
                    }
                }
                steps++;
            }
            return steps;
        }

        private boolean isVisited(int x, int y) {
            return vis[x + 302][y + 302];
        }

        private void visit(int x, int y) {
            vis[x + 302][y + 302] = true;
        }
    }
}