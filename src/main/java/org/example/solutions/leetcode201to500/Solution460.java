package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution460 {
    class LFUCache {
        private int minFreq = 1;
        private final HashMap<Integer, Node> key2Node, freq2Dummy;
        private final int capacity;


        public LFUCache(int capacity) {
            this.capacity = capacity;
            key2Node = new HashMap<>();
            freq2Dummy = new HashMap<>();
        }

        public int get(int key) {
            Node node = getNode(key);
            return node == null ? -1 : node.val;
        }

        public void put(int key, int value) {
            Node node = getNode(key);
            if (node != null) {
                node.val = value;
                return;
            }
            if (key2Node.size() == capacity) {
                Node dummy = freq2Dummy.get(minFreq);
                Node backOfLeastUsed = dummy.prev;
                key2Node.remove(backOfLeastUsed.key);
                remove(backOfLeastUsed);
                if (dummy.prev == dummy) { // empty
                    freq2Dummy.remove(backOfLeastUsed.freq);
                }
            }
            node = new Node(key, value);
            key2Node.put(key, node);
            pushFront(1, node);
            minFreq = 1;
        }

        static class Node {
            public int freq = 1, key, val;
            public Node prev, next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        private Node newHead() {
            Node dummy = new Node(0, 0);
            dummy.next = dummy;
            dummy.prev = dummy;
            return dummy;
        }

        private void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }

        private void pushFront(int freq, Node node) {
            freq2Dummy.putIfAbsent(freq, newHead());
            Node dummy = freq2Dummy.get(freq);
            node.next = dummy.next;
            node.prev = dummy;
            node.next.prev = node;
            node.prev.next = node;
        }

        private Node getNode(int key) {
            if (!key2Node.containsKey(key)) {
                return null;
            }
            Node node = key2Node.get(key);
            remove(node);
            Node dummy = freq2Dummy.get(node.freq);
            if (dummy.prev == dummy) { // empty
                freq2Dummy.remove(node.freq);
                if (node.freq == minFreq) {
                    minFreq++;
                }
            }
            node.freq++;
            pushFront(node.freq, node);
            return node;
        }
    }
}