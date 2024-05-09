package org.example.solutions.leetcode1kto2k;

public class Solution1274 {
    interface Sea {
        boolean hasShips(int[] topRight, int[] bottomLeft);
    }

    class Solution {
        public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
            if (topRight[0] < bottomLeft[0] || topRight[1] < bottomLeft[1] ||
                    !sea.hasShips(topRight, bottomLeft)) {
                return 0;
            }
            int x1 = bottomLeft[0], y1 = bottomLeft[1], x2 = topRight[0], y2 = topRight[1];
            if (x1 == x2 && y1 == y2) {
                return 1;
            }
            int midX = (x1 + x2) / 2, midY = (y1 + y2) / 2;
            return countShips(sea, new int[]{midX, midY}, bottomLeft)
                    + countShips(sea, topRight, new int[]{midX + 1, midY + 1})
                    + countShips(sea, new int[]{x2, midY}, new int[]{midX + 1, y1})
                    + countShips(sea, new int[]{midX, y2}, new int[]{x1, midY + 1});
        }
    }
}