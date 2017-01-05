package fr.flegac.experiments.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapTest {
    public static class Pair {
        public int x;

        public int y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

    }

    public static class Item {

        String name;

        int version;

        public Item(String name, int version) {
            super();
            this.name = name;
            this.version = version;
        }

        public String getName() {
            return name;
        }

        public int getVersion() {
            return version;
        }

        @Override
        public String toString() {
            return name + "-" + version;
        }

    }

    private static Comparator<Item> comparator = (a, b) -> {
        return Integer.compare(a.version, b.version);
    };

    public static void main(String[] args) {
        test2();

    }

    private static void test2() {
        String output = Stream.of(1, 3, 5, 7, 12)
            .map(i -> new Pair(i, i * i))
            .flatMap(pair -> Stream.of(pair.x, pair.y))
            .reduce(0, (a, b) -> a + b).toString();
        System.out.println(output);
    }

    private static void test() {
        Map<String, List<Item>> output = IntStream
            .range(0, 20)
            .mapToObj(x -> new Item("item" + x % 5, x))
            .collect(Collectors.groupingBy(Item::getName));

        System.out.println(output);

        Map<String, Optional<Item>> output2 = IntStream
            .range(0, 20)
            .mapToObj(x -> new Item("item" + x % 5, x))
            .collect(Collectors.groupingBy(Item::getName, Collectors.maxBy(comparator)));

        System.out.println(output2);
    }
}
