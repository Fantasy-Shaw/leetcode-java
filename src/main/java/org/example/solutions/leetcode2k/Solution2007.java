package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2007 {
    class Solution {
        public int[] findOriginalArray(int[] changed) {
            Map<Integer, Integer> map = new HashMap<>();
            Arrays.sort(changed);
            for (int x : changed) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            List<Integer> ans = new ArrayList<>();
            for (int x : changed) {
                if (map.isEmpty()) {
                    break;
                }
                int y = x * 2;
                if (map.containsKey(x) && map.containsKey(y)) {
                    if (x == 0 && y == 0) {
                        int f = map.get(x);
                        if (f >= 2) {
                            ans.add(0);
                            if (f == 2) {
                                map.remove(0);
                            } else {
                                map.put(0, f - 2);
                            }
                        }
                    } else {
                        ans.add(x);
                        int fx = map.get(x), fy = map.get(y);
                        if (fx == 1) {
                            map.remove(x);
                        } else {
                            map.put(x, fx - 1);
                        }
                        if (fy == 1) {
                            map.remove(y);
                        } else {
                            map.put(y, fy - 1);
                        }
                    }
                }
            }
            return map.isEmpty() ? ans.stream().mapToInt(i -> i).toArray() : new int[0];
        }
    }
}