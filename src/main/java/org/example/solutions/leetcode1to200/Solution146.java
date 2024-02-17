package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution146 {
    class LRUCache {
        // LinkedHashMap

        Map<Integer, LinkedNode> cache;
        LinkedNode head, tail;
        int capacity, size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            head = new LinkedNode();
            tail = new LinkedNode();
            head.next = tail;
            cache = new HashMap<>();
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            var node = cache.get(key);
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                var node = cache.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                LinkedNode node = new LinkedNode(key, value);
                cache.put(key, node);
                addToHead(node);
                if (++size > capacity) {
                    var rmNode = removeTail();
                    cache.remove(rmNode.key);
                    size--;
                }
            }
        }

        static class LinkedNode {
            public int key, value;
            public LinkedNode prev, next;

            LinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
                prev = null;
                next = null;
            }

            LinkedNode() {
                key = 0;
                value = 0;
                prev = null;
                next = null;
            }
        }

        void addToHead(LinkedNode node) {
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
        }

        void addToTail(LinkedNode node) {
            node.prev = head.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }

        void removeNode(LinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void moveToHead(LinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        LinkedNode removeTail() {
            var node = tail.prev;
            removeNode(node);
            return node;
        }
    }

    class LRUCache1 extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache1(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return super.size() > capacity;
        }
    }
}