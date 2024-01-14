package org.example.solutions.leetcode1to200;

import org.example.utils.ListNode;

import java.util.*;

public class Solution83 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode t = head;
            if (t == null || t.next == null) return t;
            while (t != null) {
                while (t.next != null && Objects.equals(t.val, t.next.val)) {
                    t.next = t.next.next;
                }
                t = t.next;
            }
            return head;
        }
    }
}