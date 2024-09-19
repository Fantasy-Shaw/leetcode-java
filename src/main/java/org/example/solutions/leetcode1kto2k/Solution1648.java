package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1648 {
    class Solution {
        static final int mod = (int) 1e9 + 7;

        public int maxProfit(int[] inventory, int orders) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            Arrays.stream(inventory).forEach(pq::add);
            long ans = 0;
            int cnt = -1;
            int cur = -1;
            while (!pq.isEmpty()) {
                if (cnt == -1) { // init
                    cnt = 1;
                    cur = pq.poll();
                }
                while (!pq.isEmpty() && pq.peek() == cur) {
                    pq.poll();
                    cnt++;
                }
                int l = pq.isEmpty() ? 0 : pq.peek();
                int m = cur - l;
                if ((long) cnt * m <= orders) {
                    long v = cnt * ((long) cur * (cur + 1) / 2 - (long) l * (l + 1) / 2);
                    ans += v;
                    ans %= mod;
                    orders -= cnt * m;
                } else {
                    int l1 = cur - orders / cnt;
                    long v = cnt * ((long) cur * (cur + 1) / 2 - (long) l1 * (l1 + 1) / 2);
                    ans += v;
                    ans %= mod;
                    ans += (long) (orders % cnt) * l1;
                    ans %= mod;
                    break;
                }
                cur = l;
            }
            return (int) ans;
        }
    }
}