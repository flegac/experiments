package fr.flegac.experiments.projecteuler.p521;

public class Problem521 {

    private static int[] primes = new int[1000000];

    private static int nextPrimeIndex = 0;

    public static void main(String[] args) {
        initPrimes(1000000);

        int N = 100;
        for (int i = 0; i < 5; i++) {

            int value = computeNumberOfIntegerWithSpecificSMPF(primes[i], N);

            System.out.println(String.format("smpf: %3d #occurences: %d", primes[i], value));
        }

    }

    private static int computeNumberOfIntegerWithSpecificSMPF(int prime, int limit) {
        return limit / prime;
    }

    private static boolean isPrime(int n) {
        for (int i = 0; i < nextPrimeIndex; i++) {
            int k = n / primes[i];
            if (n == k * primes[i]) {
                return false;
            }
        }
        return true;
    }

    private static void initPrimes(int limit) {
        long startTime = System.currentTimeMillis();
        primes[nextPrimeIndex++] = 2;
        int n = primes[nextPrimeIndex - 1];
        while (n < Math.min(limit, primes.length)) {
            if (isPrime(n)) {
                primes[nextPrimeIndex++] = n;
            }
            n++;
        }

        long time = System.currentTimeMillis() - startTime;
        System.out.println(String.format("InitPrimes : %ds", time / 1000));
        System.out.println(primes[nextPrimeIndex - 1]);
    }

}
