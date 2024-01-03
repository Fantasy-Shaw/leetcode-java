package org.example.utils;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
