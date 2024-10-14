package org.example.solutions.leetcode201to500;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution295 {
    class MedianFinder { // 对顶堆动态维护中位数
        PriorityQueue<Integer> pqMn, pqMx;


        public MedianFinder() {
            pqMn = new PriorityQueue<>();
            pqMx = new PriorityQueue<>(Collections.reverseOrder());
        }

        public void addNum(int num) {
            if (pqMx.isEmpty() || num <= pqMx.peek()) {
                pqMx.offer(num);
                if (pqMn.size() + 1 < pqMx.size()) {
                    pqMn.offer(pqMx.poll());
                }
            } else {
                pqMn.offer(num);
                if (pqMn.size() > pqMx.size()) {
                    pqMx.offer(pqMn.poll());
                }
            }
        }

        public double findMedian() {
            if (pqMx.size() > pqMn.size()) {
                return pqMx.peek() * 1.0;
            }
            return (pqMx.peek() + pqMn.peek()) / 2.0;
        }
    }
}