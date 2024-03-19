package org.example.solutions.leetcode1to200;

import java.util.*;

import org.example.utils.ListNode;

public class Solution143 {
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            Deque<ListNode> deque = new ArrayDeque<>();
            var t = head.next;
            while (t != null) {
                deque.offerLast(t);
                t = t.next;
                deque.peekLast().next = null;
            }
            t = head;
            while (!deque.isEmpty()) {
                t.next = deque.pollLast();
                t = t.next;
                if (!deque.isEmpty()) {
                    t.next = deque.pollFirst();
                    t = t.next;
                }
            }
        }
    }
}