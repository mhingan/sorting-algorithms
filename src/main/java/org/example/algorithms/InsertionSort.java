package org.example.algorithms;

import java.util.Random;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = new int[1000000];
        Random random = new Random();

        // Generating random numbers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);  // values between 0 and 999
        }

        // Sorting and measuring time and number of rounds
        long startTime = System.nanoTime();
        int numRounds = insertionSort(array);
        long endTime = System.nanoTime();
        long durationInNs = endTime - startTime;
        double durationInMs = durationInNs / 1_000_000.0;

        System.out.println("Number of rounds: " + numRounds);
        System.out.println("Time taken (milliseconds): " + durationInMs);
    }

    public static int insertionSort(int[] array) {
        int n = array.length;
        int numRounds = 0;

        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Shifting elements of array[j] that are greater than key
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
                numRounds++;  // Incrementing the number of rounds during shifting
            }
            array[j + 1] = key;

            // Incrementing the number of rounds for each insertion
            numRounds++;
        }

        return numRounds;
    }
}
