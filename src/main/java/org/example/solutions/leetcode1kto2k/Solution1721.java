package org.example.solutions.leetcode1kto2k;

import java.util.*;

import org.example.utils.ListNode;

public class Solution1721 {
    class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode kth = null;
            ListNode t = head;
            int n = 0;
            while (t != null) {
                if (n + 1 == k) {
                    kth = t;
                }
                t = t.next;
                n++;
            }
            ListNode _kth = head;
            for (int i = 0; i < n - k; i++) {
                _kth = _kth.next;
            }
            int x = kth.val;
            kth.val = _kth.val;
            _kth.val = x;
            return head;
        }
    }
}