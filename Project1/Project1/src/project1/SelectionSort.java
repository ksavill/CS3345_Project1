package project1;


public class SelectionSort {
    // initialize variables
    static int comparisons;
    static int movements;
	/** The method for sorting the numbers */
	public static void selectionSort(int[] list) { //int[] list?
            //resetting the comparison and movements metrics
            comparisons = 0;
            movements = 0;
		for (int i = 0; i < list.length -1; i++) {
			// Find the minimum in the list[i..list.length-1]
			int currentMin = list[i];
			int currentMinIndex = i;
			
			for (int j = i+1; j < list.length; j++) {
				if (currentMin > list[j]) {
					currentMin = list[j];
					currentMinIndex = j;
				}
                                comparisons++;
			}
			
			//	Swap list[i] wiht list[currentMinIndex[ if necessary
                        comparisons++;
			if (currentMinIndex != i) {
				list[currentMinIndex] = list[i];
				list[i] = currentMin;
                                movements++;
			}
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
