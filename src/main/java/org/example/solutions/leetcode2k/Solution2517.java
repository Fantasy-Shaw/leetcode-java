package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2517 {
    private class Solution {
        public int maximumTastiness(int[] price, int k) {
            Arrays.sort(price);
            int left = 0, right = price[price.length - 1] - price[0];
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (check(price, k, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }

        private boolean check(int[] price, int k, int mid) {
            int prev = -0x3f3f3f3f;
            int cnt = 0;
            for (int p : price) {
                if (p - prev >= mid) {
                    cnt++;
                    prev = p;
                }
            }
            return cnt >= k;
        }
    }
}