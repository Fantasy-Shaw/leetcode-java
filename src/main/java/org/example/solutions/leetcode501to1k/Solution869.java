package org.example.solutions.leetcode501to1k;

public class Solution869 {
    static
    class Solution {
        private static final int[][] p2;

        static {
            p2 = new int[31][];
            for (int i = 0; i < 31; i++) {
                p2[i] = count(1 << i);
            }
        }

        public boolean reorderedPowerOf2(int n) {
            int[] cnt = count(n);
            for (int i = 0; i < 31; i++) {
                if (equals(cnt, p2[i])) {
                    return true;
                }
            }
            return false;
        }

        private static int[] count(int n) {
            char[] s = String.valueOf(n).toCharArray();
            int[] cnt = new int[10];
            for (char c : s) {
                cnt[c - '0']++;
            }
            return cnt;
        }

        private static boolean equals(int[] cnt1, int[] cnt2) {
            for (int i = 0; i < 10; i++) {
                if (cnt1[i] != cnt2[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}