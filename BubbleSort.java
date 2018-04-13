import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class BubbleSort <T extends Comparable<T>>  {
	
	public BubbleSort () {
		
		
	}
	/**
	 * 
	 * @param items - collection that will be bubblesorted
	 */
	public <T extends Comparable<T>> void bubbleSort(Collection<T> items ) {
		
		//check if collection is list
		if ( items instanceof List) {
			//perform traditional bubble sort
			for (int i = 0; i < items.size()-1; i++) {
				for (int t = 0; t < items.size() - i - 1; t++) {
					
					//cast items to List of T
					if (((List<T>) items).get(t+1).compareTo(((List<T>) items).get(t)) < 0) {
						T tempItem = ((List<T>) items).get(t);
						((List<T>) items).set(t, ((List<T>) items).get(t + 1));
						((List<T>) items).set(t + 1, tempItem);
					}
					
					
				}
				
			}
		}
		
		
	}
	

}
