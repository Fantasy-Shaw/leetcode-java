package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution970 {
    class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> ans = new HashSet<>();
            if (x == 1 && y == 1) {
                if (2 <= bound) {
                    ans.add(2);
                    return new ArrayList<>(ans);
                }
            }
            if (x == 1 || y == 1) {
                int base = (x == 1) ? y : x, t = 1;
                while (t + 1 <= bound) {
                    ans.add(t + 1);
                    t *= base;
                }
                return new ArrayList<>(ans);
            }
            for (int tx = 1; tx <= bound; tx *= x) {
                for (int ty = 1; tx + ty <= bound; ty *= y) {
                    ans.add(tx + ty);
                }
            }
            return new ArrayList<>(ans);
        }
    }
}