package org.example.solutions.leetcode1to200;

import org.example.utils.ListNode;

public class Solution92 {
    class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            if (head == null || head.next == null || left == right) {
                return head;
            }
            ListNode dummyHead = new ListNode(-1);
            dummyHead.next = head;
            ListNode l = head, prev = dummyHead;
            for (int i = 1; i < left; i++) {
                prev = l;
                l = l.next;
            }
            ListNode r = l;
            for (int i = left; i < right; i++) {
                r = r.next;
            }
            ListNode tmp = r.next;
            r.next = null;
            reverseList(l);
            prev.next = r;
            l.next = tmp;
            return dummyHead.next;
        }

        public ListNode reverseList(ListNode head) { // 206
            if (head == null || head.next == null) {
                return head;
            }
            var ans = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return ans;
        }
    }
}