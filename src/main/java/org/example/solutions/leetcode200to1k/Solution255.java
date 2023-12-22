package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution255 {
    class Solution {
        // Monostack O(N) (Impl with deque)
        public boolean verifyPreorder(int[] preorder) {
            if (preorder.length <= 2) return true;
            Deque<Integer> stack = new ArrayDeque<>();
            int min = Integer.MIN_VALUE;
            for (int cur : preorder) {
                if (cur < min) {
                    return false;
                }
                while (!stack.isEmpty() && cur > stack.peek()) {
                    min = stack.pop();
                }
                stack.push(cur);
            }
            return true;
        }
    }
}