package org.example.templates;

import java.util.*;

public
class MultiSet<T> {
    private final TreeMap<T, Integer> treeMap;
    private int sz;

    public MultiSet() {
        treeMap = new TreeMap<>();
        sz = 0;
    }

    public MultiSet(Comparator<T> comparator) {
        treeMap = new TreeMap<>(comparator);
        sz = 0;
    }

    public boolean contains(T x) {
        return treeMap.containsKey(x);
    }

    public int size() {
        return sz;
    }

    public boolean isEmpty() {
        return sz == 0;
    }

    public void add(T x) {
        treeMap.put(x, treeMap.getOrDefault(x, 0) + 1);
        sz++;
    }

    public void remove(T x) {
        int freq = treeMap.get(x);
        if (freq == 1) {
            treeMap.remove(x);
        } else {
            treeMap.put(x, freq - 1);
        }
        sz--;
    }

    public T pollFirst() {
        T ans = treeMap.firstKey();
        int freq = treeMap.firstEntry().getValue();
        if (freq == 1) {
            treeMap.pollFirstEntry();
        } else {
            treeMap.put(ans, freq - 1);
        }
        sz--;
        return ans;
    }

    public T pollLast() {
        T ans = treeMap.lastKey();
        int freq = treeMap.lastEntry().getValue();
        if (freq == 1) {
            treeMap.pollLastEntry();
        } else {
            treeMap.put(ans, freq - 1);
        }
        sz--;
        return ans;
    }

    public T peekFirst() {
        return treeMap.firstKey();
    }

    public T peekLast() {
        return treeMap.lastKey();
    }
}