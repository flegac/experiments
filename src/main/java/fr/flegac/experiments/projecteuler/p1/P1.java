package fr.flegac.experiments.projecteuler.p1;

public class P1 {
    public static void main(String[] args) {
        long cpt = 0;
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                cpt += i;
            }
        }
        System.out.println(cpt);
    }
}
