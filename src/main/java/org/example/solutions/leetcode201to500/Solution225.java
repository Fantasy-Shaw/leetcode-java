package org.example.solutions.leetcode201to500;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution225 {
    class MyStack {
        Queue<Integer> qu1, qu2;

        public MyStack() {
            qu1 = new ArrayDeque<>();
            qu2 = new ArrayDeque<>();
        }

        public void push(int x) {
            qu2.offer(x);
            while (!qu1.isEmpty()) {
                qu2.offer(qu1.poll());
            }
            var temp = qu1;
            qu1 = qu2;
            qu2 = temp;
        }

        public int pop() {
            return qu1.poll();
        }

        public int top() {
            return qu1.peek();
        }

        public boolean empty() {
            return qu1.isEmpty();
        }
    }
}