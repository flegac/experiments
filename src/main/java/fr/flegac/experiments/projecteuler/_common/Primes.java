package fr.flegac.experiments.projecteuler._common;

import java.math.BigInteger;

public class Primes {

    private BigInteger[] primes = new BigInteger[100000];

    private int nextPrimeIndex = 0;

    public static void main(String[] args) {
        Primes primes = new Primes(100000);
        System.out.println(primes.isPrime(101));
    }

    public BigInteger getPrimeNumber(int index) {
        return primes[index];
    }

    public Primes(long limit) {
        this(BigInteger.valueOf(limit));
    }

    public BigInteger findBiggestPrimeFactor(BigInteger n) {
        BigInteger result = null;
        int index = 0;

        do {
            if (n.mod(getPrimeNumber(index)).compareTo(BigInteger.ZERO) == 0) {
                result = getPrimeNumber(index);
            }
            index++;
        }
        while ((getPrimeNumber(index).compareTo(n) <= 0));
        return result;
    }

    public Primes(BigInteger limit) {
        super();
        initPrimes(limit);
    }

    private boolean isPrime(long n) {
        return isPrime(BigInteger.valueOf(n));
    }

    private boolean isPrime(BigInteger n) {
        if (!n.isProbablePrime(1000)) {
            return false;
        }
        for (int i = 0; i < nextPrimeIndex; i++) {
            if (n.mod(primes[i]).compareTo(BigInteger.ZERO) == 0 && n.compareTo(primes[i]) != 0) {
                return false;
            }
        }
        return true;
    }

    private void initPrimes(BigInteger limit) {
        long startTime = System.currentTimeMillis();
        BigInteger big_2 = BigInteger.valueOf(2);

        primes[nextPrimeIndex++] = big_2;
        BigInteger n = primes[nextPrimeIndex - 1];

        while (n.compareTo(limit) <= 0 && nextPrimeIndex < primes.length) {
            if (isPrime(n)) {
                primes[nextPrimeIndex++] = n;
            }
            n = n.add(BigInteger.ONE);

        }

        long time = System.currentTimeMillis() - startTime;
        System.out.println(String.format("InitPrimes : %ds", time / 1000));
        System.out.println(primes[nextPrimeIndex - 1]);
    }

}
