package org.example.solutions.leetcode1to200;

import java.util.*;

import org.example.utils.ListNode;

public class Solution147 {
    class Solution1 {
        public ListNode insertionSortList(ListNode head) {
            List<Integer> list = new ArrayList<>();
            ListNode t = head;
            while (t != null) {
                list.add(t.val);
                t = t.next;
            }
            Collections.sort(list);
            t = head;
            for (int n : list) {
                t.val = n;
                t = t.next;
            }
            return head;
        }
    }

    class Solution {
        // Insertion Sort
        public ListNode insertionSortList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode lastSorted = head, cur = head.next;
            while (cur != null) {
                if (lastSorted.val <= cur.val) {
                    lastSorted = lastSorted.next;
                } else {
                    ListNode prev = dummyHead;
                    while (prev.next.val < cur.val) {
                        prev = prev.next;
                    }
                    lastSorted.next = cur.next;
                    cur.next = prev.next;
                    prev.next = cur;
                }
                cur = lastSorted.next;
            }
            return dummyHead.next;
        }
    }
}