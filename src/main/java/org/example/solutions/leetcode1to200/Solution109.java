package org.example.solutions.leetcode1to200;

import java.util.*;

import org.example.utils.ListNode;
import org.example.utils.TreeNode;

public class Solution109 {
    class Solution1 {
        // Divide and Conquer O(nlogn)
        public TreeNode sortedListToBST(ListNode head) {
            return buildTree(head, null);
        }

        private TreeNode buildTree(ListNode left, ListNode right) {
            if (left == right) {
                return null;
            }
            ListNode mid = getMedian(left, right);
            TreeNode node = new TreeNode(mid.val);
            node.left = buildTree(left, mid);
            node.right = buildTree(mid.next, right);
            return node;
        }

        private ListNode getMedian(ListNode left, ListNode right) {
            ListNode fast = left, slow = left;
            while (fast != right && fast.next != right) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }

    class Solution {
        // Divide and Conquer + inorder, O(N)
        private ListNode head;

        public TreeNode sortedListToBST(ListNode head) {
            this.head = head;
            int len = getLength(head);
            return buildTree(0, len - 1);
        }

        private TreeNode buildTree(int left, int right) {
            if (left > right) return null;
            int mid = (left + right + 1) / 2;
            TreeNode root = new TreeNode();
            root.left = buildTree(left, mid - 1);
            root.val = head.val;
            head = head.next;
            root.right = buildTree(mid + 1, right);
            return root;
        }

        private int getLength(ListNode head) {
            int ans = 0;
            ListNode t = head;
            while (t != null) {
                t = t.next;
                ans++;
            }
            return ans;
        }
    }
}