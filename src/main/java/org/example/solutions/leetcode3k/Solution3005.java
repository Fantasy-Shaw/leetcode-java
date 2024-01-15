package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3005 {
    class Solution {
        public int maxFrequencyElements(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            List<int[]> list = new ArrayList<>(map.size());
            for (var p : map.entrySet()) {
                list.add(new int[]{p.getKey(), p.getValue()});
            }
            list.sort(Comparator.comparingInt(value -> -value[1])); //desc
            int ans = list.getFirst()[1], mxFreq = list.getFirst()[1];
            for (int i = 1; i < list.size(); i++) {
                if (Objects.equals(mxFreq, list.get(i)[1])) ans += mxFreq;
                else break;
            }
            return ans;
        }
    }
}
