package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2866 {
    class Solution1 {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            int[] a = maxHeights.stream().mapToInt(i -> i).toArray();
            int n = maxHeights.size();
            long[] suf = new long[n + 1];
            Deque<Integer> st = new ArrayDeque<>();
            st.push(n);
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                int x = a[i];
                while (st.size() > 1 && x <= a[st.peek()]) {
                    int j = st.pop();
                    sum -= (long) a[j] * (st.peek() - j);
                }
                sum += (long) x * (st.peek() - i);
                suf[i] = sum;
                st.push(i);
            }
            long ans = sum;
            st.clear();
            st.push(-1);
            long pre = 0;
            for (int i = 0; i < n; i++) {
                int x = a[i];
                while (st.size() > 1 && x <= a[st.peek()]) {
                    int j = st.pop();
                    pre -= (long) a[j] * (j - st.peek());
                }
                pre += (long) x * (i - st.peek());
                ans = Math.max(ans, pre + suf[i + 1]);
                st.push(i);
            }
            return ans;
        }
    }

    class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            int[] a = maxHeights.stream().mapToInt(i -> i).toArray();
            int n = a.length;
            long[] prefix = new long[n], suffix = new long[n];
            long ans = 0;
            Deque<Integer> st1 = new ArrayDeque<>(), st2 = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                while (!st1.isEmpty() && a[i] < a[st1.peek()]) {
                    st1.pop();
                }
                if (st1.isEmpty()) {
                    prefix[i] = (long) (i + 1) * a[i];
                } else {
                    prefix[i] = prefix[st1.peek()] + (long) (i - st1.peek()) * a[i];
                }
                st1.push(i);
            }
            for (int i = n - 1; i >= 0; i--) {
                while (!st2.isEmpty() && a[i] < a[st2.peek()]) {
                    st2.pop();
                }
                if (st2.isEmpty()) {
                    suffix[i] = (long) (n - i) * a[i];
                } else {
                    suffix[i] = suffix[st2.peek()] + (long) (st2.peek() - i) * a[i];
                }
                st2.push(i);
                ans = Math.max(ans, prefix[i] + suffix[i] - a[i]);
            }
            return ans;
        }
    }
}