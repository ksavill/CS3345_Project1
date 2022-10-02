package project1;

public class QuickSort {
    // initialize variables
    static int comparisons;
    static int movements;
	public static void quickSort(int[] list) {
            //resetting the comparison and movements metrics
            comparisons = 0;
            movements = 0;
            quickSort(list, 0, list.length-1);
	}
	
	public static void quickSort(int[] list, int first, int last) {
            comparisons++;
            if (last > first) {
                int pivotIndex = partition(list, first, last);
                quickSort(list, first, pivotIndex -1);
                quickSort(list, pivotIndex + 1, last);
            }
                
                
	}
	
	/** Partition the array list[first..last] */
	public static int partition(int[] list, int first, int last) {
                // corrected pivot as this seemed to be causing infinite recursion.
		int pivot = (first+last)/2; // Choose the first element as the pivot
		int low = first + 1; // Index for forward search
		int high = last; //Index for backward search
		
		while (high > low) {
                    comparisons++;
			// Search forward from left
			while (low <= high && list[low] <= pivot) {
                            comparisons++;
                            low++;
                        }
			
			// Search backward from right
			while (low <= high && list[high] > pivot) {
                            comparisons++;
                            high--;
                        }
			
			//	Swap two elements in the list
                        comparisons++;
			if (high > low) {
                            int temp = list[high];
                            list[high] = list[low];
                            list[low] = temp;
                            movements++;
			}
		}
		
		while (high > first && list[high] >= pivot) {
                    comparisons++;
                    high--;
                }
		
		//	Swap pivot with list[high]
                comparisons++;
		if (pivot > list[high]) {
                    list[first] = list[high];
                    list[high] = pivot; 
                    movements++;
                    return high;
		}
		else {
			return first;
		}
                
	}
        // callable methods to return statistics
        public int comparisons() {
            return comparisons;
        }
        public int movements() {
            return movements;
        }
}
