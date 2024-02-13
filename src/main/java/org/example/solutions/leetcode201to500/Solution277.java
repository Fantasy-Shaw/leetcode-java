package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution277 {
    class Relation {
        public boolean knows(int a, int b) {
            return false;
        }
    }

    public class Solution extends Relation {
        public int findCelebrity(int n) {
            int result = 0;
            for (int i = 1; i < n; i++) {
                if (knows(result, i)) {
                    result = i;
                }
            }
            for (int i = 0; i < n; i++) {
                if (result == i) continue;
                if (knows(result, i) || !knows(i, result)) return -1;
            }
            return result;
        }
    }
}