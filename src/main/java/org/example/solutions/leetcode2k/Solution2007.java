package org.example.solutions.leetcode2k;

import org.example.templates.MultiSet;

import java.util.*;

public class Solution2007 {
    class Solution {
        public int[] findOriginalArray(int[] changed) {
            MultiSet<Integer> set = new MultiSet<>();
            Arrays.sort(changed);
            for (int x : changed) {
                set.add(x);
            }
            List<Integer> ans = new ArrayList<>();
            for (int x : changed) {
                if (set.isEmpty()) {
                    break;
                }
                int y = x * 2;
                if (set.contains(x) && set.contains(y)) {
                    if (x == 0 && y == 0) {
                        set.remove(0);
                        if (set.contains(0)) {
                            set.remove(0);
                            ans.add(0);
                        } else {
                            set.add(0);
                        }
                    } else {
                        ans.add(x);
                        set.remove(x);
                        set.remove(y);
                    }
                }
            }
            return set.isEmpty() ? ans.stream().mapToInt(i -> i).toArray() : new int[0];
        }
    }
}