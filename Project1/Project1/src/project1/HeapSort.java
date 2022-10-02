package project1;


public class HeapSort {
    // initialize variables
    static int comparisons;
    static int movements;
    
	/** Heap sort method */
	public static <E extends Comparable<E>> void heapSort(E[] list) {
            //resetting the comparison and movements metrics
            comparisons=0;
            movements=0;
		//	Create a Heap of integers
		Heap<E> heap = new Heap<>();
                heap.resetCounters();
		
		//	Add elements to the heap
                comparisons++;
		for (int i = 0; i < list.length; i++) {
                    comparisons++;
			heap.add(list[i]);
                }
		
		//	Remove elements from the heap
                comparisons++;
		for (int i = list.length -1; i >= 0; i--) {
                    comparisons++;
			list[i] = heap.remove();
                }
                int heapcomp = heap.comparisons();
                int heapmove = heap.movements();
                comparisons+=heapcomp;
                movements+=heapmove;
	}
        
	
	
 	/**	A test method */
//	public static void main(String[] args) {
//		Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
//		heapSort(list);
//		for(int i = 0; i < list.length; i++)
//			System.out.println(list[i] + " ");
//	}
        public int comparisons() {
            return comparisons;
        }
        public int movements() {
            return movements;
        }
	
}
