package org.example.solutions.leetcode501to1k;

public class Solution622 {
    class MyCircularQueue {
        final int maxSize;
        int head, tail;
        int[] data;

        public MyCircularQueue(int k) {
            this.maxSize = k;
            head = tail = 0;
            data = new int[k];
        }

        public boolean enQueue(int value) {
            if (isFull()) {
                return false;
            }
            data[tail % maxSize] = value;
            tail++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) {
                return false;
            }
            head++;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : data[head % maxSize];
        }

        public int Rear() {
            return isEmpty() ? -1 : data[(tail - 1) % maxSize];
        }

        public boolean isEmpty() {
            return head == tail;
        }

        public boolean isFull() {
            return tail - head == maxSize;
        }
    }
}