package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2517 {
    class Solution {
        public int maximumTastiness(int[] price, int k) {
            Arrays.sort(price);
            int l = 0, r = price[price.length - 1] - price[0] + 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (check(price, k, mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l - 1;
        }

        private boolean check(int[] price, int k, int mid) {
            int cnt = 1, pre = price[0];
            for (int p : price) {
                if (p >= pre + mid) {
                    cnt++;
                    pre = p;
                }
            }
            return cnt >= k;
        }
    }
}