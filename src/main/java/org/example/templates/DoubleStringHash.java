package org.example.templates;

public
class DoubleStringHash {
    private static final int P1 = 131, P2 = 233;

    private static final long M1 = 998243783, M2 = 1000000097;
    private final long[] hash1, prime1, hash2, prime2;

    public DoubleStringHash(CharSequence str) {
        int n = str.length();
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

    private static boolean isPrime(long x) {
        for (long i = 2; i * i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (long i = 998200000; i < 1e9 + 100; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }
}
