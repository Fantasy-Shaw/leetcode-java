package org.example.solutions.leetcode201to500;

import java.util.LinkedList;
import java.util.List;

public class Solution281 {
    public class ZigzagIterator {
        private final LinkedList<Integer> vec0, vec1;
        private int idx;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            vec0 = new LinkedList<>(v1);
            vec1 = new LinkedList<>(v2);
            idx = 0;
        }

        public int next() {
            if (vec0.isEmpty() && vec1.isEmpty()) {
                return -1;
            }
            if (idx % 2 == 0) {
                int ans = vec0.isEmpty() ? vec1.pollFirst() : vec0.pollFirst();
                idx++;
                return ans;
            } else {
                int ans = vec1.isEmpty() ? vec0.pollFirst() : vec1.pollFirst();
                idx++;
                return ans;
            }
        }

        public boolean hasNext() {
            return !(vec0.isEmpty() && vec1.isEmpty());
        }
    }
}