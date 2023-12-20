package org.example.solutions.leetcode200to1k;

import org.example.utils.ListNode;

import java.util.*;

public class Solution203 {
    class Solution {
        public ListNode removeElements(ListNode head, int val) {
            ListNode dummyHead = new ListNode(0);
            dummyHead.next = head;
            ListNode t = dummyHead;
            while (t.next != null) {
                if (t.next.val == val) {
                    t.next = t.next.next;
                } else {
                    t = t.next;
                }
            }
            return dummyHead.next;
        }
    }
}