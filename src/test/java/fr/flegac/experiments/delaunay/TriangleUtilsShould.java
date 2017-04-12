package fr.flegac.experiments.delaunay;

import java.io.FileNotFoundException;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import fr.flegac.experiments.delaunay.VecArray.Vec;
import fr.flegac.experiments.delaunay.v2.TriangleUtils;

public class TriangleUtilsShould {
    private static Random rand = new Random();

    @Test
    public void loadData() throws FileNotFoundException {
        // given
        VecArray data = new VecArray(4);
        Vec D = data.get(0);
        Vec A = data.get(1);
        Vec B = data.get(2);
        Vec C = data.get(3);
        A.set(0, 1);
        B.set(0, 0);
        C.set(1, 0);

        int N = 10000;
        int count = 0;

        for (int i = 0; i < N; i++) {
            D.set(rand.nextFloat(), rand.nextFloat());
        }

        // when
        D.set(8, 8);

        // then
        Assert.assertEquals(true, TriangleUtils.inCircle(D, A, B, C));

    }

}
