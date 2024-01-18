package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2171 {
    class Solution {
        public long minimumRemoval(int[] beans) {
            long sum = 0;
            for (int bean : beans) {
                sum += bean;
            }
            Arrays.sort(beans);
            long remainedBeans = 0;
            for (int i = 0; i < beans.length; i++) {
                remainedBeans = Math.max(remainedBeans, (long) (beans.length - i) * beans[i]);
            }
            return sum - remainedBeans;
        }
    }
}