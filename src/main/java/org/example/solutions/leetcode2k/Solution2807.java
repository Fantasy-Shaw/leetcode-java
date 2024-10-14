package org.example.solutions.leetcode2k;

import org.example.utils.ListNode;


public class Solution2807 {
    class Solution {
        public ListNode insertGreatestCommonDivisors(ListNode head) {
            if (head.next == null) return head;
            ListNode n1 = head, n2 = head.next;
            while (n2 != null) {
                ListNode n = new ListNode(gcd(n1.val, n2.val));
                n1.next = n;
                n.next = n2;
                n1 = n2;
                n2 = n2.next;
            }
            return head;
        }

        private static int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
}