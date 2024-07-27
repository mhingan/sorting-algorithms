package org.example.algorithms;

import java.util.Random;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[1000000];
        Random random = new Random();

        // Generating random numbers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);  // values between 0 and 999
        }

        System.out.println("Numbers generated successfully.");

        // Sorting and measuring time
        long startTime = System.nanoTime();
        int numIterations = selectionSort(array);
        long endTime = System.nanoTime();
        long durationInNs = endTime - startTime;
        double durationInMs = durationInNs / 1_000_000.0;

        System.out.println("Number of external iterations: " + numIterations);
        System.out.println("Time taken (milliseconds): " + durationInMs);
    }

    public static int selectionSort(int[] array) {
        int n = array.length;
        int numIterations = 0;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the index of the smallest element in array[i+1, ..., n-1]
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the current element
            if (minIndex != i) {
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }

            numIterations++; // Increment the number of external iterations
        }

        return numIterations;
    }
}
