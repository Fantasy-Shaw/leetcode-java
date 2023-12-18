package org.example.solutions;

import java.util.*;

public class Solution2276 {
    private class CountIntervals {
        private final TreeMap<Integer, Integer> tm = new TreeMap<>();
        private int cnt;

        public CountIntervals() {

        }

        public void add(int left, int right) {
            for (Map.Entry<Integer, Integer> e = tm.ceilingEntry(left); e != null && e.getValue() <= right; e = tm.ceilingEntry(left)) {
                int l = e.getValue(), r = e.getKey();
                left = Math.min(left, l);
                right = Math.max(right, r);
                cnt -= (r - l + 1);
                tm.remove(r);
            }
            cnt += (right - left + 1);
            tm.put(right, left);
        }

        public int count() {
            return cnt;
        }
    }
}