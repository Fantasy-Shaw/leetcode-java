package org.example.solutions.leetcode1to200;

import org.example.utils.ListNode;

import java.util.*;

public class Solution23 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
            for (ListNode head : lists) {
                if (head != null) {
                    pq.offer(head);
                }
            }
            ListNode dummyHead = new ListNode(0);
            ListNode t = dummyHead;
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                if (node.next != null) {
                    pq.offer(node.next);
                }
                t.next = node;
                t = t.next;
            }
            return dummyHead.next;
        }
    }
}