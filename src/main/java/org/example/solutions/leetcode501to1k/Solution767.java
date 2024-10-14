package org.example.solutions.leetcode501to1k;

import java.util.PriorityQueue;

public class Solution767 {
    class Solution {
        public String reorganizeString(String s) {
            int[] map = new int[128];
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i)]++;
            }
            PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map[b] - map[a]);
            for (int i = 'a'; i <= 'z'; i++) {
                if (map[i] > 0) {
                    pq.offer((char) i);
                }
            }
            StringBuilder ans = new StringBuilder();
            while (ans.length() < s.length()) {
                char ch = pq.poll();
                if (!ans.isEmpty() && ch == ans.charAt(ans.length() - 1)) {
                    if (pq.isEmpty()) {
                        return "";
                    } else {
                        char ch2 = pq.poll();
                        pq.offer(ch);
                        ch = ch2;
                    }
                }
                if (--map[ch] > 0) {
                    pq.offer(ch);
                }
                ans.append(ch);
            }
            return ans.toString();
        }
    }
}