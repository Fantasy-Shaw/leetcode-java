package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution313 {
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            long[] uglyNums = new long[n + 1];
            uglyNums[1] = 1;
            int[] iter = new int[primes.length];
            Arrays.fill(iter, 1);
            for (int idx = 2; idx <= n; idx++) {
                long[] t = new long[primes.length];
                for (int i = 0; i < primes.length; i++) {
                    t[i] = uglyNums[iter[i]] * primes[i];
                }
                long min = getMinElem(t);
                for (int i = 0; i < primes.length; i++) {
                    if (min == t[i]) iter[i]++;
                }
                uglyNums[idx] = min;
            }
            return (int) uglyNums[n];
        }

        private long getMinElem(long[] arr) {
            long ans = Long.MAX_VALUE;
            for (var n : arr) {
                ans = Math.min(n, ans);
            }
            return ans;
        }
    }
}