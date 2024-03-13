package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3074 {
    class Solution {
        public int minimumBoxes(int[] apple, int[] capacity) {
            int s = Arrays.stream(apple).sum();
            Arrays.sort(capacity);
            int ans = 0;
            for (int i = capacity.length - 1; i >= 0; i--) {
                s -= capacity[i];
                ans++;
                if (s <= 0) break;
            }
            return ans;
        }
    }
}