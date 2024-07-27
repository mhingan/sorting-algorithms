package org.example.algorithms;

import java.util.Random;

public class MergeSort {

    private static int numIterations = 0; // Variable to track the number of iterations

    public static void main(String[] args) {
        int[] array = new int[1000000];
        Random random = new Random();

        // Generating random numbers
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1000);  // values between 0 and 999
        }

        // Sorting and measuring time
        long startTime = System.nanoTime();
        mergeSort(array, 0, array.length - 1);
        long endTime = System.nanoTime();
        long durationInNs = endTime - startTime;
        double durationInMs = durationInNs / 1_000_000.0;

        System.out.println("Time taken (milliseconds): " + durationInMs);
        System.out.println("Number of iterations: " + numIterations); // Print the number of iterations
    }

    // Main Merge Sort function
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Sort the first and second halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the two halves
            merge(array, left, mid, right);
        }
    }

    // Merge function
    public static void merge(int[] array, int left, int mid, int right) {
        // Sizes of the subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copy data to temporary arrays
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        // Merge the temporary arrays back into the original array
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            numIterations++; // Increment iteration count for each comparison
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        // Copy the remaining elements
        while (i < n1) {
            numIterations++; // Increment iteration count for each remaining element copy
            array[k++] = L[i++];
        }
        while (j < n2) {
            numIterations++; // Increment iteration count for each remaining element copy
            array[k++] = R[j++];
        }
    }
}
