package org.example.solutions.leetcode2k;

import java.util.HashSet;
import java.util.Set;

public class Solution2549 {
    class Solution {
        public int distinctIntegers(int n) {
            Set<Integer> set = new HashSet<>();
            set.add(n);
            for (int k = 1; k <= n; k++) {
                Set<Integer> cur = new HashSet<>();
                for (int x : set) {
                    for (int i = 1; i <= n; i++) {
                        if (x % i == 1) {
                            cur.add(i);
                        }
                    }
                }
                int m = set.size();
                set.addAll(cur);
                if (m == set.size()) break;
            }
            return set.size();
        }
    }
}