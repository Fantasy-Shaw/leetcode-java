package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution358 {
    class Solution {
        public String rearrangeString(String s, int k) {
            if (k == 0) return s;
            Map<Character, Integer> map = new HashMap<>();
            PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(value -> -value.second));
            for (char c : s.toCharArray()) {
                map.put(c, 1 + map.getOrDefault(c, 0));
            }
            for (var pair : map.entrySet()) {
                pq.add(new Pair<>(pair));
            }
            StringBuilder ans = new StringBuilder();
            Queue<Pair<Character, Integer>> qu = new ArrayDeque<>();
            while (!pq.isEmpty()) {
                var pair = pq.poll();
                char ch = pair.first;
                int freq = pair.second;
                ans.append(ch);
                qu.offer(new Pair<>(ch, freq - 1));
                if (qu.size() == k) {
                    var pair2 = qu.poll();
                    if (pair2.second > 0) {
                        pq.offer(pair2);
                    }
                }
            }
            return ans.length() == s.length() ? ans.toString() : "";
        }

        private static class Pair<_Tp1, _Tp2> {
            public _Tp1 first;
            public _Tp2 second;

            public Pair(_Tp1 first, _Tp2 second) {
                this.first = first;
                this.second = second;
            }

            public Pair(Map.Entry<_Tp1, _Tp2> pair) {
                this.first = pair.getKey();
                this.second = pair.getValue();
            }
        }
    }
}