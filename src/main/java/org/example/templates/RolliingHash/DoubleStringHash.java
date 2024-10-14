package org.example.templates.RolliingHash;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public
class DoubleStringHash {
    private static final int P1 = 131, P2 = 233;

    private static final long M1 = 998243783, M2 = 1000000097;

    private final long[] hash1, prime1, hash2, prime2;

    private final int n;

    public DoubleStringHash(CharSequence str) {
        n = str.length();
        hash1 = new long[n + 1];
        hash2 = new long[n + 1];
        prime1 = new long[n + 1];
        prime2 = new long[n + 1];
        prime1[0] = 1;
        prime2[0] = 1;
        for (int i = 0; i < n; i++) {
            prime1[i + 1] = (prime1[i] * P1) % M1;
            prime2[i + 1] = (prime2[i] * P2) % M2;
            hash1[i + 1] = (hash1[i] * P1) % M1 + str.charAt(i);
            hash2[i + 1] = (hash2[i] * P2) % M2 + str.charAt(i);
            if (hash1[i + 1] >= M1) {
                hash1[i + 1] -= M1;
            }
            if (hash2[i + 1] >= M2) {
                hash2[i + 1] -= M2;
            }
        }
    }

    public long[] getHash(int i, int j) {
        return new long[]{
                (hash1[j] - hash1[i] * prime1[j - i] % M1 + M1) % M1,
                (hash2[j] - hash2[i] * prime2[j - i] % M2 + M2) % M2
        };
    }

    public long getHashcode(int i, int j) {
        long[] hash = getHash(i, j);
        return hash[0] << 32 | hash[1];
    }

    public int size() {
        return n;
    }

    private static boolean isPrime(long x) {
        for (long i = 2; i * i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Long> nums = new ArrayList<>();
        for (long i = 998200000; i < 1e9 + 100; i++) {
            nums.add(i);
        }
        List<Long> prime = new CopyOnWriteArrayList<>();
        nums.parallelStream().forEach(i -> {
            if (isPrime(i)) {
                prime.add(i);
            }
        });
        prime.sort(Comparator.naturalOrder());
        prime.forEach(i -> System.out.printf("%d\n", i));
    }
}
