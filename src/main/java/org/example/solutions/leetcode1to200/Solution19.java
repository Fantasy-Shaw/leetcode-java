package org.example.solutions.leetcode1to200;

import org.example.utils.ListNode;

public class Solution19 {
    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slow = dummy, fast = dummy;
            for (int i = 0; i < n; i++) {
                fast = fast.next;
            }
            ListNode pre = dummy;
            while (fast != null) {
                fast = fast.next;
                pre = slow;
                slow = slow.next;
            }
            pre.next = slow.next;
            return dummy.next;
        }
    }
}