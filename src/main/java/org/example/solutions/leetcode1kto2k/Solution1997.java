package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1997 {
    class Solution {
        static final int mod = (int) 1e9 + 7;

        public int firstDayBeenInAllRooms(int[] nextVisit) {
            int n = nextVisit.length;
            long[] s = new long[n];
            for (int i = 0; i <= n - 2; i++) {
                int j = nextVisit[i];
                s[i + 1] = (2 * s[i] - s[j] + 2 + mod) % mod;
            }
            return (int) s[n - 1];
        }
    }
}