package fr.flegac.experiments.projecteuler.p1;

import java.math.BigInteger;

import fr.flegac.experiments.projecteuler._common.Primes;

public class P3 {
    public static void main(String[] args) {

        Primes primes = new Primes(1000000);
        BigInteger result = primes.findBiggestPrimeFactor(new BigInteger("600851475143"));
        System.out.println(result);
    }

}
