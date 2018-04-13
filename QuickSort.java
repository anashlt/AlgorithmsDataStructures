import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class QuickSort <T extends Comparable<T>> {

	/**
	 * 
	 * @param items - collection that will be quicksorted
	 * @param start - start index of the collection - usually 0
	 * @param end - end index of the collection - usually its size-1
	 */
	public <T extends Comparable<T>> void quickSort(Collection<T> items , int start, int end ) {
		
		//check if collection is of type list
		if ( items instanceof List) {
			int i = start;

	        int j = end;


	        if (j - i >= 1) {
	        	
	        	//select pivot and cast items to list of T
	            T pivot = ((List<T>) items).get(i);

	            while (j > i)
	            {

	                while (((List<T>) items).get(i).compareTo(pivot) <= 0 && i < end && j > i){
	                    i++;
	                }

	                while (((List<T>) items).get(j).compareTo(pivot) >= 0 && j > start && j >= i){
	                    j--;
	                }

	                if (j > i) {
	                    swap(items, i, j);
	                }
	            }

	            swap(items, start, j);
	            
	            //perform recursion to continue sorting collection
	            quickSort(items, start, j - 1);

	            quickSort(items, j + 1, end);
			
	        }
			
			
		}
		
		
	}
	/**
	 * 
	 * @param items - the collection where the elements will be swapped from
	 * @param i - the index of the element that will be swapped
	 * @param j - the index of the element that will be swapped
	 */
	public <T> void swap(Collection<T> items , int i , int j) {
		if (items instanceof List) {
			T temp = ((List<T>) items).get(i);
			((List<T>) items).set(i, ((List<T>) items).get(j));
			((List<T>) items).set(j, temp);
		}
	}
	
}
