package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution705 {
    class MyHashSet {
        private final BitSet bitSet;

        public MyHashSet() {
            bitSet = new BitSet(100005);
        }

        public void add(int key) {
            bitSet.set(key);
        }

        public void remove(int key) {
            bitSet.clear(key);
        }

        public boolean contains(int key) {
            return bitSet.get(key);
        }
    }
}
