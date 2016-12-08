package fr.flegac.experiments.projecteuler.p206;

import java.math.BigInteger;

public class P206 {
    static BigInteger target = new BigInteger("102030405060708090");

    public static void main(String[] args) {
        BigInteger current = new BigInteger("1010101030");
        patternFound(target);
    }

    private static boolean patternFound(BigInteger value) {
        BigInteger result = new BigInteger("0");
        for (int i = 0; i < 10; i++) {
            testDigit(value, i);
        }

        System.out.println(result);
        return true;
    }

    private static boolean testDigit(BigInteger value, int i) {
        BigInteger digit = new BigInteger("10").pow(2 * i);

        return value.mod(digit).intValue() == i;
    }

}
