package org.example.solutions.leetcode2k;

public class Solution3000 {
    class Solution {
        public int areaOfMaxDiagonal(int[][] dimensions) {
            int curMx = dimensions[0][0] * dimensions[0][0] + dimensions[0][1] * dimensions[0][1];
            int mxArea = dimensions[0][0] * dimensions[0][1];
            for (int i = 1; i < dimensions.length; i++) {
                int cur = dimensions[i][0] * dimensions[i][0] + dimensions[i][1] * dimensions[i][1];
                if (cur > curMx) {
                    curMx = cur;
                    mxArea = dimensions[i][0] * dimensions[i][1];
                } else if (cur == curMx) {
                    mxArea = Math.max(mxArea, dimensions[i][0] * dimensions[i][1]);
                }
            }
            return mxArea;
        }
    }
}
