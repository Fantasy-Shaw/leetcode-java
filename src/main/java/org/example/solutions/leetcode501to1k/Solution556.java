package org.example.solutions.leetcode501to1k;

public class Solution556 {
    class Solution {
        public int nextGreaterElement(int n) {
            if (n < 10) {
                return -1;
            }
            char[] cs = String.valueOf(n).toCharArray();
            int i = cs.length - 2;
            while (i >= 0 && cs[i] >= cs[i + 1]) {
                i--;
            }
            if (i < 0) {
                return -1;
            }
            int j = cs.length - 1;
            while (j >= 0 && cs[i] >= cs[j]) {
                j--;
            }
            swap(cs, i, j);
            reverse(cs, i + 1, cs.length);
            long ans = Long.parseLong(new String(cs));
            return ans <= Integer.MAX_VALUE && ans > n ? (int) ans : -1;
        }

        static void swap(char[] cs, int x, int y) {
            char t = cs[x];
            cs[x] = cs[y];
            cs[y] = t;
        }

        static void reverse(char[] cs, int l, int r) {
            int n = r - l;
            for (int i = 0; i < n / 2; i++) {
                char t = cs[l + i];
                cs[l + i] = cs[r - i - 1];
                cs[r - i - 1] = t;
            }
        }
    }
}