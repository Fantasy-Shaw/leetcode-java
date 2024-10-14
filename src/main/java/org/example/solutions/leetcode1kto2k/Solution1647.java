package org.example.solutions.leetcode1kto2k;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1647 {
    class Solution {
        public int minDeletions(String s) {
            int[] map = new int[128];
            for (char c : s.toCharArray()) {
                map[c]++;
            }
            PriorityQueue<Character> pq = new PriorityQueue<>(Comparator.comparingInt(ch -> -map[ch]));
            for (char i = 'a'; i <= 'z'; i++) {
                if (map[i] != 0) {
                    pq.offer(i);
                }
            }
            int ans = 0;
            while (!pq.isEmpty()) {
                char a = pq.poll();
                if (pq.isEmpty() || map[a] != map[pq.peek()]) {
                    continue;
                }
                ans++;
                if (--map[a] != 0) {
                    pq.offer(a);
                }
            }
            return ans;
        }
    }
}