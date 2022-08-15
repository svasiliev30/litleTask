package org.example;

import java.util.*;

public class ListObjectInt {
    static List<IntObjects> listIntObjects = new ArrayList<>();
    static Map<Integer, IntObjects> mapCashIntObjects = new HashMap<>();

    public static void InitializationIntObjects() {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < 4; i++) {
            a = (int) (Math.random() * 100);
            b = (int) (Math.random() * 100);
            c = (int) (Math.random() * 100);
            mapCashIntObjects.put(i, new IntObjects(a, b, c));
            listIntObjects.add(new IntObjects(a, b, c));
        }
    }

    public static void main(String[] args) {
        int capacityIntObjects = 3;
        InitializationIntObjects();
        listIntObjects.stream()
                .forEach(s -> System.out.println("Первое число - " + s.a
                        + ", Второе число - " + s.b
                        + ", Третие число - " + s.c));

        List<Integer> listSum = new ArrayList<>();
        listIntObjects.stream()
                .forEach(f -> {
                    listSum.add(f.a + f.b + f.c);
                });

        Optional<Integer> totalAmount = listSum.stream()
                .reduce((firstSum, secondSum) -> firstSum + secondSum);

        int middleResult = totalAmount.get() / listIntObjects.size();

        List<IntObjects> firstGroupLessMiddle = new ArrayList<>();
        List<IntObjects> firstGroupHighMiddle = new ArrayList<>();

        for (int z = 0; z < listSum.size(); z++) {
            int result = listSum.get(z);
            if (result < middleResult) {
                firstGroupLessMiddle.add(mapCashIntObjects.get(z));
            } else {
                firstGroupHighMiddle.add(mapCashIntObjects.get(z));
            }
        }
        System.out.println("---------------------------------");
        firstGroupLessMiddle.stream().forEach(s -> System.out.println("Первая группа (Первое число - " + s.a
                + ", Второе число - " + s.b
                + ", Третие число - " + s.c));
        System.out.println("---------------------------------");
        firstGroupHighMiddle.stream().forEach(s -> System.out.println("Вторая группа группа (Первое число - " + s.a
                + ", Второе число - " + s.b
                + ", Третие число - " + s.c));
    }
}
