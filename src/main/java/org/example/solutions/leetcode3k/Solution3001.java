package org.example.solutions.leetcode3k;

public class Solution3001 {
    static class Solution {
        public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
            // (a,b)-car, (c,d)-elp, (e,f)-queen
            int car = Integer.MAX_VALUE, elp = Integer.MAX_VALUE;
            if (a != e && b != f) {
                car = 2;
            } else {
                if (a == e) car = (a == c && between(b, d, f)) ? 2 : 1;
                if (b == f) car = (b == d && between(a, c, e)) ? 2 : 1;
            }
            if (Math.abs(c - e) * 1.0 / Math.abs(d - f) == 1.0) {
                elp = 1;
                if (Math.abs(a - e) * 1.0 / Math.abs(b - f) == 1.0) {
                    if (between(c, a, e) && between(d, b, f)) elp = 3;
                }
            } else {
                elp = 2;
                if ((Math.abs(a - e) * 1.0 / Math.abs(b - f) == 1.0) || (Math.abs(a - c) * 1.0 / Math.abs(b - d) == 1.0)) {
                    elp = 4;
                }
            }
            return Math.min(car, elp);
        }

        private static boolean between(int l, int mid, int r) {
            return (l < mid && mid < r) || (r < mid && mid < l);
        }
    }
}