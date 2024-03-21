package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2671 {
    class FrequencyTracker {
        Map<Integer, Integer> num2freq;
        Map<Integer, Set<Integer>> freq2nums;

        public FrequencyTracker() {
            num2freq = new HashMap<>();
            freq2nums = new HashMap<>();
        }

        public void add(int number) {
            if (num2freq.containsKey(number)) {
                int freq = num2freq.get(number);
                freq2nums.get(freq).remove(number);
                num2freq.put(number, freq + 1);
                freq2nums.putIfAbsent(freq + 1, new HashSet<>());
                freq2nums.get(freq + 1).add(number);
            } else {
                num2freq.put(number, 1);
                freq2nums.putIfAbsent(1, new HashSet<>());
                freq2nums.get(1).add(number);
            }
        }

        public void deleteOne(int number) {
            if (!num2freq.containsKey(number)) {
                return;
            }
            int freq = num2freq.get(number);
            freq2nums.get(freq).remove(number);
            if (freq > 1) {
                num2freq.put(number, freq - 1);
                freq2nums.putIfAbsent(freq - 1, new HashSet<>());
                freq2nums.get(freq - 1).add(number);
            } else { // freq == 1
                num2freq.remove(number);
            }
        }

        public boolean hasFrequency(int frequency) {
            return freq2nums.containsKey(frequency) && !freq2nums.get(frequency).isEmpty();
        }
    }
}