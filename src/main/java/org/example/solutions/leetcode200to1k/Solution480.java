package org.example.solutions.leetcode200to1k;

import org.example.templates.MultiSet;

import java.util.*;

public class Solution480 {
    class Solution {
        public double[] medianSlidingWindow(int[] nums, int k) {
            List<Double> ans = new ArrayList<>();
            MedianFinder medianFinder = new MedianFinder();
            for (int i = 0; i < k - 1; i++) {
                medianFinder.addNum(nums[i]);
            }
            for (int i = k - 1; i < nums.length; i++) {
                medianFinder.addNum(nums[i]);
                ans.add(medianFinder.findMedian());
                medianFinder.rmNum(nums[i - k + 1]);
            }
            return ans.stream().mapToDouble(value -> value).toArray();
        }
    }

    class MedianFinder {
        // 对顶堆动态维护中位数 扩展 Leetcode-295 增加remove
        MultiSet<Long> pqMn, pqMx;


        public MedianFinder() {
            pqMn = new MultiSet<>();
            pqMx = new MultiSet<>(Collections.reverseOrder());
        }

        public void addNum(long num) {
            if (pqMx.isEmpty() || num <= pqMx.peekFirst()) {
                pqMx.add(num);
                if (pqMn.size() + 1 < pqMx.size()) {
                    pqMn.add(pqMx.pollFirst());
                }
            } else {
                pqMn.add(num);
                if (pqMn.size() > pqMx.size()) {
                    pqMx.add(pqMn.pollFirst());
                }
            }
        }

        public void rmNum(long num) {
            if (pqMx.contains(num)) {
                pqMx.remove(num);
                while (pqMn.size() > pqMx.size()) {
                    pqMx.add(pqMn.pollFirst());
                }
            } else if (pqMn.contains(num)) {
                pqMn.remove(num);
                while (pqMn.size() + 1 < pqMx.size()) {
                    pqMn.add(pqMx.pollFirst());
                }
            }
        }

        public double findMedian() {
            if (pqMx.size() > pqMn.size()) {
                return pqMx.peekFirst() * 1.0;
            }
            return (pqMx.peekFirst() + pqMn.peekFirst()) / 2.0;
        }
    }
}