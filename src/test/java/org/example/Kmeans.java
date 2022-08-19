package org.example;

import java.util.Arrays;

public class Kmeans {
    static final int CAPACITY = 30;

    public static void main(String[] args) {
        int[] numbers = getRandomArrayWithNumbers();
        int i;
        int firstCentroid;
        int secondCentroid;
        int iteration = 0;
        boolean flag;
        int sum1;
        int sum2;
        int cluster1[] = new int[numbers.length];
        int cluster2[] = new int[numbers.length];

        int cashFirstCentroid = 35;
        int cashSecondCentroid = 65;
        firstCentroid = cashFirstCentroid;
        secondCentroid = cashSecondCentroid;

        do {
            sum1 = 0;
            sum2 = 0;
            cluster1 = new int[numbers.length];
            cluster2 = new int[numbers.length];
            iteration++;
            int k = 0;
            int j = 0;
            for (i = 0; i < numbers.length; i++) {
                if (Math.abs(numbers[i] - firstCentroid) <= Math.abs(numbers[i] - secondCentroid)) {
                    cluster1[k] = numbers[i];
                    k++;
                } else {
                    cluster2[j] = numbers[i];
                    j++;
                }
            }
            for (i = 0; i < k; i++) {
                sum1 += cluster1[i];
            }
            for (i = 0; i < j; i++) {
                sum2 += cluster2[i];
            }
            cashFirstCentroid = firstCentroid;
            cashSecondCentroid = secondCentroid;
            firstCentroid = sum1 / k;
            secondCentroid = sum2 / j;

            flag = (firstCentroid == cashFirstCentroid & secondCentroid == cashSecondCentroid);
            ToStringInformation(firstCentroid, secondCentroid, iteration, cluster1, cluster2);

        } while (flag);
        FinalyToStringInformation(firstCentroid, secondCentroid, cluster1, cluster2);
    }

    private static int[] getRandomArrayWithNumbers() {
        int[] numbers = new int[CAPACITY];
        for (int v = 0; v < numbers.length; v++) {
            numbers[v] = (int) (Math.random() * 100);
        }
        return numbers;
    }

    private static void FinalyToStringInformation(int firstCentroid, int secondCentroid, int[] cluster1, int[] cluster2) {
        System.out.println("Final values of cenral firstCentroid =" + firstCentroid + ", secondCentroid = " + secondCentroid);
        System.out.println( Arrays.toString(cluster1));
        System.out.println("_________________________");
        System.out.println(Arrays.toString(cluster2));
        System.out.println("\n");
    }

    private static void ToStringInformation(int firstCentroid, int secondCentroid, int iteration, int[] cluster1, int[] cluster2) {
        System.out.println("firstCentroid = " + firstCentroid + ", secondCentroid = " + secondCentroid);
        System.out.println(" After iteration" + iteration + Arrays.toString(cluster1));
        System.out.println("_________________________");
        System.out.println(" After iteration" + iteration + Arrays.toString(cluster2));
    }
}
//https://www.youtube.com/watch?v=a2dXXlYEZug&ab_channel=VlasChekaida