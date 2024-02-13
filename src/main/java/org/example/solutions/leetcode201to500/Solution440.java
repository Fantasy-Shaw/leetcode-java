package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution440 {
    class Solution {
        public int findKthNumber(int n, int k) {
            int cur = 1;
            k--; // '1' is the 1-st number, cur = 1 and k = k - 1
            while (k > 0) {
                long step = 0, first = cur, last = cur + 1;
                while (first <= n) {
                    step += Math.min((long) n + 1, last) - first;
                    first *= 10;
                    last *= 10;
                }
                if (step <= k) {
                    cur++;
                    k -= step;
                } else {
                    cur *= 10;
                    k--;
                }
            }
            return cur;
        }
    }
}