package project1;


public class InsertionSort {
    // initialize variables
    static int comparisons;
    static int movements;
	/**The method for sorting the numbers */
	public static void insertionSort(int[] list) {
            //resetting the comparison and movements metrics
            comparisons = 0;
            movements = 0;
		for (int i = 1; i < list.length; i++) {
			/** Insert list[i] into a sorted sublist list[0..i-1] so that 
			 * 	list[0..i] is sorted
			 */
			int currentElement = list[i];
			int k;
			for (k = i-1; k>= 0 && list[k] > currentElement; k--) {
				list[k+1] = list[k];
                                // add movement
                                comparisons++;
                                movements++;
			}
			
			//insert the current element into list[k + 1]
			list[k + 1] = currentElement;
                        comparisons++;
                        
			
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
