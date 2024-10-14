package org.example.solutions.leetcode201to500;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution451 {
    class Solution {
        public String frequencySort(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(value -> -value.second));
            for (var pair : map.entrySet()) {
                pq.offer(new Pair<>(pair.getKey(), pair.getValue()));
            }
            StringBuilder ans = new StringBuilder();
            while (!pq.isEmpty()) {
                var p = pq.poll();
                for (int i = 0; i < p.second; i++) {
                    ans.append(p.first);
                }
            }
            return ans.toString();
        }

        private static class Pair<_Tp1, _Tp2> {
            public _Tp1 first;
            public _Tp2 second;

            public Pair(_Tp1 first, _Tp2 second) {
                this.first = first;
                this.second = second;
            }
        }
    }
}