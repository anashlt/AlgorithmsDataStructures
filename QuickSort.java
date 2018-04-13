
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class QuickSort <T extends Comparable<T>> {

	/**
	 * 
	 * @param items - collection that will be quicksorted
	 * @param start - start index of the collection - usually 0
	 * @param end - end index of the collection - usually its size-1
	 */
	public <T extends Comparable<T>> void quickSort(Collection<T> items , int start, int end ) {
		
		
		int i = start;

        int j = end;

        List<T> tempList = new LinkedList<T>();
		tempList.addAll(items);
        if (j - i >= 1) {
        	
        	//select pivot and cast items to list of T
            T pivot = tempList.get(i);

            while (j > i)
            {

                while (tempList.get(i).compareTo(pivot) <= 0 && i < end && j > i){
                    i++;
                }

                while (tempList.get(j).compareTo(pivot) >= 0 && j > start && j >= i){
                    j--;
                }

                if (j > i) {
                    swap(tempList, i, j);
                }
            }

            swap(tempList, start, j);
          
            //perform recursion to continue sorting collection
            quickSort(tempList, start, j - 1);
            
            quickSort(tempList, j + 1, end);
		
        }
       	items.clear();
    	items.addAll(tempList);
        
        
		
		
	}
	/**
	 * 
	 * @param items - the collection where the elements will be swapped from
	 * @param i - the index of the element that will be swapped
	 * @param j - the index of the element that will be swapped
	 */
	public <T> void swap(Collection<T> items , int i , int j) {
		List<T> tempList = new LinkedList<T>();
		tempList.addAll(items);
		T temp = tempList.get(i);
		tempList.set(i, tempList.get(j));
		tempList.set(j, temp);
		
		items.clear();
		items.addAll(tempList);
		
	}
	
}
