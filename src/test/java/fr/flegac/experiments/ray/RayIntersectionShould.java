package fr.flegac.experiments.ray;

import org.junit.Assert;
import org.junit.Test;

public class RayIntersectionShould {
    @Test
    public void computeIntersection() {
        // given
        Sphere sphere = new Sphere1(new Vec1(0, 0, 0), 2);
        Ray ray = new Ray1(new Vec1(10, 0, 0), new Vec1(9, 0, 0));
        Vec expected = new Vec1(2, 0, 0);

        // when
        RayIntersection intersection = new RayIntersection(sphere, ray);
        Vec vec = intersection.intersection();

        // then
        System.out.println(vec);
        Assert.assertEquals(expected, vec);
    }

    @Test
    public void computeIntersection2() {
        // given
        Sphere sphere = new Sphere1(new Vec1(5, 0, 0), 2);
        Ray ray = new Ray1(new Vec1(10, 0, 0), new Vec1(9, 0, 0));
        Vec expected = new Vec1(7, 0, 0);

        // when
        RayIntersection intersection = new RayIntersection(sphere, ray);
        Vec vec = intersection.intersection();

        // then
        System.out.println(vec);
        Assert.assertEquals(expected, vec);

    }

    @Test
    public void computeIntersection3() {
        // given
        Sphere sphere = new Sphere1(new Vec1(1, 2, 3), 5);
        Ray ray = new Ray1(new Vec1(1000, 0, 0), new Vec1(9000, 1, 2));
        Vec expected = new Vec1(4.1537795f, -0.124480724f, -0.24896145f);

        // when
        RayIntersection intersection = new RayIntersection(sphere, ray);
        Vec vec = intersection.intersection();

        // then
        System.out.println(vec);
        Assert.assertEquals(expected, vec);

    }
}
