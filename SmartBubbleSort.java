import java.util.Collection;
import java.util.List;

public class SmartBubbleSort <T extends Comparable<T>>{
	
	/**
	 * 
	 * @param items - collection that will be smart bubble sorted
	 */
	public <T extends Comparable<T>> void smartBubbleSort(Collection<T> items ) {
		
		//check if collection is list
		if ( items instanceof List) {
			
			//check if its sorted with boolean
			boolean sorted = false;
			//loop while not sorted
			while (!sorted) {
				sorted = true;
				//perform bubble sort
				for (int i = 0; i < items.size()-1; i++) {
					
					for (int t = 0; t < items.size() - i - 1; t++) {
						
						//cast items to list of T
						if (((List<T>) items).get(t+1).compareTo(((List<T>) items).get(t)) < 0) {
							T tempItem = ((List<T>) items).get(t);
							((List<T>) items).set(t, ((List<T>) items).get(t + 1));
							((List<T>) items).set(t + 1, tempItem);
							sorted = false;
						}
						
					}
					
				}
			}
			
			
		}
		
		
	}

}
