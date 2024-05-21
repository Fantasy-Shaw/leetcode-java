package org.example.templates.RolliingHash;

public
class StringHash {
    private static final int p = 1313131;
    private final long[] hash, prime;

    public StringHash(CharSequence str) {
        int n = str.length();
        hash = new long[n + 10];
        prime = new long[n + 10];
        prime[0] = 1;
        for (int i = 0; i < n; i++) {
            prime[i + 1] = prime[i] * p;
            hash[i + 1] = hash[i] * p + str.charAt(i);
        }
    }

    public long getHash(int i, int j) {
        return hash[j] - hash[i] * prime[j - i];
    }
}
