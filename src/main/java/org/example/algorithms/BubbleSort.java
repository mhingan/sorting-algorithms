package org.example.algorithms;

import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[1000000];
        Random random = new Random();

        // Generating random numbers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);  // values between 0 and 999
        }

        // Sorting and measuring time and number of rounds
        long startTime = System.nanoTime();
        int numRuns = bubbleSort(array);
        long endTime = System.nanoTime();
        long durationInNs = endTime - startTime;
        double durationInMs = durationInNs / 1_000_000.0;

        System.out.println("Number of rounds: " + numRuns);
        System.out.println("Time taken (milliseconds): " + durationInMs);
    }

    public static int bubbleSort(int[] array) {
        int n = array.length;
        int numRuns = 0;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            numRuns++;  // Incrementing the number of rounds for each outer iteration
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swapping
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swaps were made, the list is sorted
            if (!swapped) break;
        }

        return numRuns;
    }
}
