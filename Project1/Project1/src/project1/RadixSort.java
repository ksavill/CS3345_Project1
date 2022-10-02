package project1;

import java.io.*;
import java.util.*;

class RadixSort {
    // initialize variables
    static int comparisons;
    static int movements;
	static int getMax(int arr[], int n) {
		int mx = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > mx) {
                            mx = arr[i];
                            movements++;
                        }
                        comparisons++;
                }
		return mx;
	}

	static void countSort(int arr[], int n, int exp) {
		int output[] = new int[n];
		int i;
		int count[] = new int[10];
		Arrays.fill(count, 0);
		for (i = 0; i < n; i++) {
			count[(arr[i] / exp) % 10]++;
                        comparisons++;
                        movements++;
                }
		// Change count[i] so that count[i] now contains
		// actual position of this digit in output[]
		for (i = 1; i < 10; i++) {
			count[i] += count[i - 1];
                        comparisons++;
                        movements++;
                }
		// Build the output array
                comparisons++;
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
                        comparisons++;
                        movements++;
		}
		for (i = 0; i < n; i++) {
			arr[i] = output[i];
                        comparisons++;
                        movements++;
                }
	}

	static void radixsort(int arr[], int n) { // Find the maximum number to know number of digits
            //resetting the comparison and movements metrics
            comparisons = 0;
            movements = 0;
		int m = getMax(arr, n);
                comparisons++;
		for (int exp = 1; m / exp > 0; exp *= 10) {
                    comparisons++;
			countSort(arr, n, exp);
                }
	}
        // not being used.
	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}
        // callable methods to return statistics
        public int comparisons() {
            return comparisons;
        }
        public int movements() {
            return movements;
        }
	/**
	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;
		radixsort(arr, n);
		print(arr, n);
	}
	*/
}