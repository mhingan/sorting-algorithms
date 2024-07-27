package org.example.algorithms;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[1000000];
        Random random = new Random();

        // Generating random numbers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);  // values between 0 and 999
        }

        // Sorting and measuring time
        long startTime = System.nanoTime();
        int numCalls = quickSort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        long durationInNs = endTime - startTime;
        double durationInMs = durationInNs / 1_000_000.0;

        System.out.println("Number of calls: " + numCalls);
        System.out.println("Time taken (milliseconds): " + durationInMs);
    }

    // Main QuickSort function
    public static int quickSort(int[] array, int low, int high) {
        int numCalls = 0;
        if (low < high) {
            int[] result = partition(array, low, high);
            int pivotIndex = result[0];
            numCalls += result[1]; // Add the number of calls from this iteration

            // Sort the subarrays
            numCalls += quickSort(array, low, pivotIndex - 1);
            numCalls += quickSort(array, pivotIndex + 1, high);
        }
        return numCalls + 1; // Return the number of calls plus 1 for the current call
    }

    // Partition function
    public static int[] partition(int[] array, int low, int high) {
        int pivot = array[high]; // Choose the pivot (in this case, the element at the end)
        int i = low - 1;
        int numCalls = 0;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Swap the elements
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
            numCalls++; // Increment the number of calls for each comparison
        }

        // Swap the pivot with the element after the last swapped position
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        numCalls++; // Increment the number of calls for the pivot swap

        return new int[] { i + 1, numCalls };
    }
}
