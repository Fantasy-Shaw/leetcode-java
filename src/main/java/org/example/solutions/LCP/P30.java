package org.example.solutions.LCP;

import java.util.*;

public class P30 {
    class Solution {
        public int magicTower(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            long hp = 1, sumSwapped = 0;
            int ans = 0;
            for (int x : nums) {
                pq.offer(x);
                hp += x;
                if (hp <= 0) {
                    ans++;
                    int mn = pq.poll();
                    sumSwapped += mn;
                    hp -= mn;
                }
            }
            hp += sumSwapped;
            return hp <= 0 ? -1 : ans;
        }
    }
}