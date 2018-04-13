import java.util.Collection;
import java.util.List;

public class InsertionSort <T extends Comparable<T>>  {
	
	/**
	 * 
	 * @param items - collection that will be insertion sorted
	 */
	public <T extends Comparable<T>> void insertionSort(Collection<T> items ) {
		
		//check if collection is list
		if ( items instanceof List) {
			
			//perform traditional insertionsort
			for(int i = 1; i < items.size(); i++)  {
			    T key = ((List<T>) items).get(i);
			    int j = i - 1;
			    
			    //cast items to list of T
			    while (j >= 0 && key.compareTo(((List<T>) items).get(j)) < 0) {
			        ((List<T>) items).set(j + 1, ((List<T>) items).get(j));
			        j--;
			    }
			    ((List<T>) items).set(j + 1, key);
			}
			
			
		}
		
		
	}
}
