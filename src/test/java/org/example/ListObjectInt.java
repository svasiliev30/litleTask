package org.example;

import java.util.*;

public class ListObjectInt {
    static List<IntObjects> listIntObjects = new ArrayList<>();
    static Map<Integer, IntObjects> mapCashIntObjects = new HashMap<>();
    final static int CAPACITY_OBJECTS = 20;

    public static void InitializationIntObjects() {
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 0; i < CAPACITY_OBJECTS; i++) {
            a = (int) (Math.random() * 100);
            b = (int) (Math.random() * 100);
            c = (int) (Math.random() * 100);
            mapCashIntObjects.put(i, new IntObjects(a, b, c));
            listIntObjects.add(new IntObjects(a, b, c));
        }
    }

    public static void main(String[] args) {
        InitializationIntObjects();
        System.out.println(" Всего - " + CAPACITY_OBJECTS + " объектов.");

        List<Integer> listSum = new ArrayList<>();
        listIntObjects.stream()
                .forEach(f -> {
                    listSum.add(f.a + f.b + f.c);
                });

        Optional<Integer> totalAmount = listSum.stream()
                .reduce((firstSum, secondSum) -> firstSum + secondSum);

        int middleResult = totalAmount.get() / listIntObjects.size();

        Map<IntObjects, Integer> firstGroupLessMiddle = new HashMap<>();
        Map<IntObjects, Integer> firstGroupHighMiddle = new HashMap<>();

        for (int z = 0; z < listSum.size(); z++) {
            int result = listSum.get(z);
            Integer sumObjects = null;
            if (result < middleResult) {
                IntObjects intObjects = mapCashIntObjects.get(z);
                sumObjects = intObjects.a + intObjects.b + intObjects.c;

                firstGroupLessMiddle.put(intObjects, sumObjects);
            } else {
                IntObjects intObjects = mapCashIntObjects.get(z);
                sumObjects = intObjects.a + intObjects.b + intObjects.c;

                firstGroupHighMiddle.put(intObjects, sumObjects);
            }
        }
        System.out.println(
                " Первая группа - Сумма объектов меньше среднего значения сумм всех объектов." +
                "\n Вторая группа - Сумма объектов больше среднего значения сумм всех объектов.");

        System.out.println("---------------------------------" +
                "\n Первая группа - " + firstGroupLessMiddle.size() + " объектов." +
                "\n---------------------------------" );
        firstGroupLessMiddle.entrySet().stream().forEach(key ->{
            System.out.println("Первое число - " + key.getKey().a
                + ", Второе число - " + key.getKey().b
                + ", Третие число - " + key.getKey().c + ". " + key.getValue() + " < " + middleResult);});

        System.out.println("---------------------------------" +
                "\n Вторая группа - " + firstGroupHighMiddle.size() + " объектов." +
                "\n---------------------------------" );
            firstGroupHighMiddle.entrySet().stream().forEach(key ->{
                System.out.println("Первое число - " + key.getKey().a
                        + ", Второе число - " + key.getKey().b
                        + ", Третие число - " + key.getKey().c + ". " + key.getValue() + " >= " + middleResult);});
    }
}
