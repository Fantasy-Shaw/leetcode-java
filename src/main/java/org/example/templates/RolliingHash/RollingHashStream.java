package org.example.templates.RolliingHash;

import java.util.ArrayList;
import java.util.List;

public
class RollingHashStream {
    private static final int p = 1313131;
    private final List<Long> hash, prime;
    public int size;

    public RollingHashStream() {
        hash = new ArrayList<>();
        prime = new ArrayList<>();
        prime.add(1L);
        hash.add(0L);
        size = 0;
    }

    public void add(int x) {
        prime.add(prime.getLast() * p);
        hash.add(hash.getLast() * p + x);
        size++;
    }

    public long getHash(int i, int j) {
        return hash.get(j) - hash.get(i) * prime.get(j - i);
    }
}