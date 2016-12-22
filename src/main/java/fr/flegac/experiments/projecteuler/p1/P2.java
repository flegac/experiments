package fr.flegac.experiments.projecteuler.p1;

public class P2 {
    public static void main(String[] args) {
        int p0 = 1;
        int p1 = 2;

        long cpt = 0;
        while (p1 <= 4000000) {
            if (p1 % 2 == 0) {
                cpt += p1;
            }

            int tmp = p0 + p1;
            p0 = p1;
            p1 = tmp;
        }

        System.out.println(cpt);

    }
}
