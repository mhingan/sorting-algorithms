package org.example;

/*
 * Copyright (c) 2024 Mihaita Hingan
 *
 * This software is released under the MIT License.
 * See https://opensource.org/licenses/MIT for details.
 */

import org.example.algorithms.*;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int[] array = generateRandomArray(1000000);

        // Testăm Bubble Sort
        testSortMethod("BubbleSort", array.clone(), BubbleSort::bubbleSort);

        // Testăm Insertion Sort
        testSortMethod("InsertionSort", array.clone(), InsertionSort::insertionSort);

        // Testăm Merge Sort
        testSortMethod("MergeSort", array.clone(), array1 -> {
            MergeSort.mergeSort(array1, 0, array1.length - 1);
            return 0;
        });

        testSortMethod("QuickSort", array.clone(), array1 -> {
            return QuickSort.quickSort(array1, 0, array1.length - 1);
        });

        testSortMethod("SelectionSort", array.clone(), SelectionSort::selectionSort);
    }

    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }


    private static void testSortMethod(String methodName, int[] array, SortMethod sortMethod) {
        long startTime = System.nanoTime();
        int numIterations = sortMethod.sort(array);
        long endTime = System.nanoTime();
        long durationInNs = endTime - startTime;
        double durationInMs = durationInNs / 1_000_000.0;

        System.out.println(methodName + " - Number of iterations: " + numIterations);
        System.out.println(methodName + " - Time taken (milliseconds): " + durationInMs);
    }

    @FunctionalInterface
    private interface SortMethod {
        int sort(int[] array);
    }
}
