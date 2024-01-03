package org.example.solutions.leetcode2k;

import java.util.*;

import org.example.utils.ListNode;

public class Solution2487 {
    class Solution {
        public ListNode removeNodes(ListNode head) {
            if (head.next == null) {
                return head;
            }
            ListNode node = removeNodes(head.next);
            if (node.val > head.val) {
                return node;
            }
            head.next = node;
            return head;
        }
    }
}