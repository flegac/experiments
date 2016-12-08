package fr.flegac.experiments.uuid;

import java.util.UUID;

import org.junit.Test;

public class UUIDTest {

    @Test
    public void testUUIDGeneration() {
        System.out.println(UUID.randomUUID());

        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
        System.out.println(UUID.randomUUID());
    }
}
