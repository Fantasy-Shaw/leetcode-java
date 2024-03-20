package org.example.templates;

import org.example.utils.ListNode;

public
class Sort {
    /**
     * Leetcode - 148. Sort List
     * Call example : mergeSort(head, null);
     */
    public static ListNode mergeSort(ListNode head, ListNode tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // slow-fast pointer : get mid
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        return merge(mergeSort(head, mid), mergeSort(mid, tail));
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        } else {
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    /**
     * Leetcode - 912. Sort An Array
     */
    public static void mergeSort(int[] nums) {
        int[] buf = new int[nums.length];
        _mergeSort(nums, 0, nums.length - 1, buf);
    }

    private static void _mergeSort(int[] nums, int l, int r, int[] buf) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) >> 1;
        _mergeSort(nums, l, mid, buf);
        _mergeSort(nums, mid + 1, r, buf);
        for (int k = l; k <= r; k++) {
            buf[k] = nums[k];
        }
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i == mid + 1) {
                nums[k] = buf[j++];
            } else if (j == r + 1 || buf[i] <= buf[j]) { // <= : stable
                nums[k] = buf[i++];
            } else {
                nums[k] = nums[j++];
            }
        }
    }
}
