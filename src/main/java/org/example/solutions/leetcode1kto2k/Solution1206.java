package org.example.solutions.leetcode1kto2k;

import java.util.Arrays;
import java.util.Random;

public class Solution1206 {
    class Skiplist {
        static final int MAX_LEVEL = 32;
        static final double P_FACTOR = 0.25;
        SkipListNode head;
        int level;
        Random random;

        public Skiplist() {
            head = new SkipListNode(-1, MAX_LEVEL);
            level = 0;
            random = new Random();
        }

        public boolean search(int target) {
            var node = _find(target, null);
            node = node.next[0];
            return node != null && node.val == target;
        }

        private SkipListNode _find(int target, SkipListNode[] update) {
            SkipListNode cur = head;
            /* 找到第 i 层小于且最接近 target 的元素*/
            for (int i = level - 1; i >= 0; i--) {
                while (cur.next[i] != null && cur.next[i].val < target) {
                    cur = cur.next[i];
                }
                if (update != null) update[i] = cur;
            }
            return cur;
        }

        public void add(int num) {
            SkipListNode[] update = new SkipListNode[MAX_LEVEL];
            Arrays.fill(update, head);
            SkipListNode cur = _find(num, update);
            int lv = randomLevel();
            level = Math.max(lv, level);
            SkipListNode node = new SkipListNode(num, lv);
            for (int i = 0; i < lv; i++) {
                /* 对第 i 层的状态进行更新，将当前元素的 forward 指向新的节点 */
                node.next[i] = update[i].next[i];
                update[i].next[i] = node;
            }
        }

        public boolean erase(int num) {
            SkipListNode[] update = new SkipListNode[MAX_LEVEL];
            Arrays.fill(update, head);
            SkipListNode cur = _find(num, update);
            cur = cur.next[0];
            if (cur == null || cur.val != num) {
                return false;
            }
            for (int i = 0; i < level; i++) {
                if (update[i].next[i] != cur) {
                    break;
                }
                update[i].next[i] = cur.next[i];
            }
            // update level
            while (level > 1 && head.next[level - 1] == null) {
                level--;
            }
            return true;
        }

        private int randomLevel() {
            int lv = 1;
            while (random.nextDouble() < P_FACTOR && lv < MAX_LEVEL) {
                lv++;
            }
            return lv;
        }

        static class SkipListNode {
            public int val;
            public SkipListNode[] next;

            public SkipListNode(int val, int MAX_LEVEL) {
                this.val = val;
                next = new SkipListNode[MAX_LEVEL];
            }
        }
    }
}