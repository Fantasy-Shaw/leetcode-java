package org.example.solutions.leetcode200to1k;

import java.util.List;

public class Solution707 {
    class MyLinkedList {
        ListNode head;

        public MyLinkedList() {
            head = new ListNode(0);
        }

        public int get(int index) {
            var t = head.next;
            while (t != null && index-- > 0) {
                t = t.next;
            }
            return t == null ? -1 : t.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val);
            node.next = head.next;
            head.next = node;
        }

        public void addAtTail(int val) {
            ListNode t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = new ListNode(val);
        }

        public void addAtIndex(int index, int val) {
            ListNode t = head;
            while (t != null && index-- > 0) {
                t = t.next;
            }
            if (t != null) {
                ListNode node = new ListNode(val);
                node.next = t.next;
                t.next = node;
            }
        }

        public void deleteAtIndex(int index) {
            ListNode t = head;
            while (t != null && index-- > 0) {
                t = t.next;
            }
            if (t != null && t.next != null) {
                t.next = t.next.next;
            }
        }

        static class ListNode {
            public int val;
            public ListNode next;

            public ListNode(int val) {
                this.val = val;
            }

            public ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }
}