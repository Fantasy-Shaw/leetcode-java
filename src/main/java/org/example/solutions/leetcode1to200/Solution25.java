package org.example.solutions.leetcode1to200;

import org.example.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution25 {
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummyHead = new ListNode(-1);
            Deque<ListNode> stack = new ArrayDeque<>();
            ListNode pre = dummyHead, t = head;
            while (true) {
                ListNode curHead = t;
                for (int i = 0; i < k && t != null; i++) {
                    stack.push(t);
                    t = t.next;
                }
                if (stack.size() < k) {
                    pre.next = curHead;
                    break;
                } else {
                    while (!stack.isEmpty()) {
                        pre.next = stack.pop();
                        pre = pre.next;
                    }
                }
            }
            return dummyHead.next;
        }
    }
}