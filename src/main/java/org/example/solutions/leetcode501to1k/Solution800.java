package org.example.solutions.leetcode501to1k;

public class Solution800 {
    class Solution {
        private static final int[] hex = {
                0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xaa, 0xbb, 0xcc, 0xdd, 0xee, 0xff
        };

        public String similarRGB(String color) {
            int r = Integer.parseInt(color.substring(1, 3), 16);
            int g = Integer.parseInt(color.substring(3, 5), 16);
            int b = Integer.parseInt(color.substring(5, 7), 16);
            String ansR = Integer.toHexString(findNearest(r));
            String ansG = Integer.toHexString(findNearest(g));
            String ansB = Integer.toHexString(findNearest(b));
            return "#" +
                    (ansR.length() == 1 ? "0" + ansR : ansR) +
                    (ansG.length() == 1 ? "0" + ansG : ansG) +
                    (ansB.length() == 1 ? "0" + ansB : ansB);
        }

        private int findNearest(int x) {
            if (x < 0x00 || x > 0xff) return -1;
            if (x % 0x11 == 0) return x;
            for (int i = 1; i < hex.length; i++) {
                if (hex[i - 1] <= x && x <= hex[i]) {
                    return Math.abs(x - hex[i - 1]) < Math.abs(x - hex[i]) ? hex[i - 1] : hex[i];
                }
            }
            return -2;
        }
    }
}