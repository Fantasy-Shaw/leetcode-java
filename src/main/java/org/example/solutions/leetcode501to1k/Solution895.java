package org.example.solutions.leetcode501to1k;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Solution895 {
    class FreqStack {
        Map<Integer, Deque<Integer>> freq2st;
        Map<Integer, Integer> freq;
        int maxFreq;

        public FreqStack() {
            freq2st = new HashMap<>();
            freq = new HashMap<>();
            maxFreq = 0;
        }

        public void push(int val) {
            int f = freq.getOrDefault(val, 0) + 1;
            freq.put(val, f);
            maxFreq = Math.max(maxFreq, f);
            freq2st.putIfAbsent(f, new ArrayDeque<>());
            freq2st.get(f).push(val);
        }

        public int pop() {
            var st = freq2st.get(maxFreq);
            int ans = st.pop();
            freq.put(ans, maxFreq - 1);
            if (st.isEmpty()) {
                maxFreq--;
            }
            return ans;
        }
    }

}