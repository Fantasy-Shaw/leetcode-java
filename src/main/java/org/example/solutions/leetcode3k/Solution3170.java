package org.example.solutions.leetcode3k;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3170 {
    class Solution {
        public String clearStars(String s) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == '*') {
                    pq.poll();
                } else {
                    pq.offer(new int[]{i, cs[i]});
                }
            }
            List<int[]> rem = new ArrayList<>(pq);
            rem.sort(Comparator.comparingInt(a -> a[0]));
            StringBuilder ans = new StringBuilder();
            for (var p : rem) {
                ans.append((char) p[1]);
            }
            return ans.toString();
        }
    }
}