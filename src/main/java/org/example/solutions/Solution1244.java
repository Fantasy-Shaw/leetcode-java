package org.example.solutions;

import java.util.*;

public class Solution1244 {
    class Leaderboard {

        private Map<Integer, Integer> map;

        public Leaderboard() {
            map = new HashMap<>();
        }

        public void addScore(int playerId, int score) {
            map.put(playerId, map.getOrDefault(playerId, 0) + score);
        }

        public int top(int K) {
            int ans = 0;
            List<Integer> list = new ArrayList<>(map.values());
            list.sort(Comparator.comparing(value -> -value));
            for (int i = 0; i < K; i++) {
                ans += list.get(i);
            }
            return ans;
        }

        public void reset(int playerId) {
            map.remove(playerId);
        }
    }
}