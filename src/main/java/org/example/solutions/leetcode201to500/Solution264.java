package org.example.solutions.leetcode201to500;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution264 {
    /**
     * 起始先将最小丑数 1 放入队列
     * 每次从队列取出最小值 x，然后将 x 所对应的丑数 2x、3x 和 5x 进行入队。
     * 对步骤 2 循环多次，第 n 次出队的值即是答案。
     */
    class Solution1 {
        // PriorityQueue O(NlogN)
        private static final int[] factors = {2, 3, 5};

        public int nthUglyNumber(int n) {
            Set<Long> set = new HashSet<>();
            PriorityQueue<Long> pq = new PriorityQueue<>();
            set.add(1L);
            pq.add(1L);
            for (int i = 1; i <= n; i++) {
                long x = pq.poll();
                if (i == n) return (int) x;
                for (int f : factors) {
                    long t = x * f;
                    if (!set.contains(t)) {
                        set.add(t);
                        pq.add(t);
                    }
                }
            }
            return -1;
        }
    }

    /**
     * 多路归并
     */
    class Solution {
        // O(N)
        public int nthUglyNumber(int n) {
            int[] uglyNums = new int[n + 1];
            uglyNums[1] = 1;
            for (int i2 = 1, i3 = 1, i5 = 1, idx = 2; idx <= n; idx++) {
                int a = uglyNums[i2] * 2, b = uglyNums[i3] * 3, c = uglyNums[i5] * 5;
                int min = Math.min(a, Math.min(b, c));
                if (min == a) i2++;
                if (min == b) i3++;
                if (min == c) i5++;
                uglyNums[idx] = min;
            }
//        System.out.println(Arrays.toString(uglyNums));
            return uglyNums[n];
        }
    }
}