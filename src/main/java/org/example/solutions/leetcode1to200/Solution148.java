package org.example.solutions.leetcode1to200;

import org.example.utils.ListNode;

public class Solution148 {
    class Solution {
        public ListNode sortList(ListNode head) {
            return mergeSort(head, null);
        }

        private ListNode mergeSort(ListNode head, ListNode tail) {
            if (head == null) {
                return null;
            }
            if (head.next == tail) {
                head.next = null;
                return head;
            }
            // slow-fast pointers -> get mid
            ListNode slow = head, fast = head;
            while (fast != tail) {
                slow = slow.next;
                fast = fast.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode mid = slow;
            return merge(mergeSort(head, mid), mergeSort(mid, tail));
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val < l2.val) {
                l1.next = merge(l1.next, l2);
                return l1;
            } else {
                l2.next = merge(l1, l2.next);
                return l2;
            }
        }
    }
}