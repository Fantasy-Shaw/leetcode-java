package org.example.solutions.leetcode201to500;

import org.example.utils.ListNode;

public class Solution206 {
    class Solution {
        public ListNode reverseList(ListNode head) {
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