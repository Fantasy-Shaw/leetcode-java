package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3020 {
    class Solution {
        public int maximumLength(int[] nums) {
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int i : nums) {
                freq.put(i, freq.getOrDefault(i, 0) + 1);
            }
            TreeSet<Integer> uniNums = new TreeSet<>(freq.keySet());
            int ans = 0;
            while (!uniNums.isEmpty()) {
                int n = uniNums.pollFirst();
                int f = freq.get(n);
                if (n == 1) {
                    int cur = (f % 2 == 1) ? f : f - 1;
                    ans = Math.max(ans, cur);
                    continue;
                }
                if (f == 1) {
                    ans = Math.max(ans, 1);
                    continue;
                }
                int cur = 2;
                int next = n;
                while (true) {
                    next *= next;
                    int nextF = freq.getOrDefault(next, 0);
                    if (nextF == 1) {
                        cur++;
                        uniNums.remove(next);
                        break;
                    } else if (nextF == 0) {
                        cur -= 1;
                        break;
                    } else {
                        uniNums.remove(next);
                        cur += 2;
                    }
                }
                ans = Math.max(cur, ans);
            }
            return ans;
        }
    }
}