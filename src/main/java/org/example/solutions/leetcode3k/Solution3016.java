package org.example.solutions.leetcode3k;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Solution3016 {
    class Solution {
        public int minimumPushes(String word) {
            int n = word.length();
            int cur = 1;
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            List<Pair<Character, Integer>> freq = new ArrayList<>();
            for (var pair : map.entrySet()) {
                freq.add(new Pair<>(pair.getKey(), pair.getValue()));
            }
            freq.sort(Comparator.comparingInt(a -> -a.second)); //desc
            int curCost = 1, n_chs = 0;
            int ans = 0;
            for (var pair : freq) {
                char ch = pair.first;
                int f = pair.second;
                ans += f * curCost;
                n_chs++;
                if (n_chs % 8 == 0) {
                    curCost++;
                }
            }
            return ans;
        }

        static class Pair<_Tp1, _Tp2> {
            public _Tp1 first;
            public _Tp2 second;

            public Pair(_Tp1 first, _Tp2 second) {
                this.first = first;
                this.second = second;
            }
        }
    }
}