import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class InsertionSort <T extends Comparable<T>>  {
	
	/**
	 * 
	 * @param items - collection that will be insertion sorted
	 */
	public <T extends Comparable<T>> void insertionSort(Collection<T> items ) {
		
		List<T> tempList = new LinkedList<T>();
		tempList.addAll(items);
		
		for(int i = 1; i < tempList.size(); i++)  {
		    T key = tempList.get(i);
		    int j = i - 1;
		    
		    //cast items to list of T
		    while (j >= 0 && key.compareTo( tempList.get(j)) < 0) {
		         tempList.set(j + 1, tempList.get(j));
		        j--;
		    }
		     tempList.set(j + 1, key);
		}
		
		items.clear();
		items.addAll(tempList);
		
	}
}
