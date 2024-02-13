package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution692 {
    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (String w : words) {
                map.put(w, map.getOrDefault(w, 0) + 1);
            }
            PriorityQueue<Pair<String, Integer>> pq = new PriorityQueue<>((a, b) -> {
                if (Objects.equals(a.second, b.second)) return a.first.compareTo(b.first);
                return b.second - a.second;
            });
            for (var pair : map.entrySet()) {
                pq.offer(new Pair<>(pair.getKey(), pair.getValue()));
            }
            List<String> ans = new ArrayList<>();
            while (!pq.isEmpty() && k-- > 0) {
                ans.add(pq.poll().first);
            }
            return ans;
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