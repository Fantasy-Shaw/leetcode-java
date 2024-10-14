package org.example.solutions.leetcode201to500;

import org.example.utils.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution445 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Deque<Integer> st1 = new ArrayDeque<>(), st2 = new ArrayDeque<>();
            ListNode head = new ListNode(0);
            int carry = 0;
            var t = l1;
            while (t != null) {
                st1.push(t.val);
                t = t.next;
            }
            t = l2;
            while (t != null) {
                st2.push(t.val);
                t = t.next;
            }
            while (!st1.isEmpty() && !st2.isEmpty()) {
                int x = st1.pop(), y = st2.pop();
                int cur = (x + y + carry) % 10;
                carry = (x + y + carry) / 10;
                ListNode node = new ListNode(cur);
                node.next = head.next;
                head.next = node;
            }
            while (!st1.isEmpty()) {
                int x = st1.pop();
                int cur = (x + carry) % 10;
                carry = (x + carry) / 10;
                ListNode node = new ListNode(cur);
                node.next = head.next;
                head.next = node;
            }
            while (!st2.isEmpty()) {
                int x = st2.pop();
                int cur = (x + carry) % 10;
                carry = (x + carry) / 10;
                ListNode node = new ListNode(cur);
                node.next = head.next;
                head.next = node;
            }
            if (carry == 1) {
                ListNode node = new ListNode(1);
                node.next = head.next;
                head.next = node;
            }
            return head.next;
        }
    }
}