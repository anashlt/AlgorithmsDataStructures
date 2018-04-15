import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
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
		
		List<T> tempList = new LinkedList<T>();
		tempList.addAll(items);
		
		for (int i = 0; i < tempList.size()-1; i++) {
			for (int t = 0; t < tempList.size() - i - 1; t++) {
				
				if ( tempList.get(t+1).compareTo( tempList.get(t)) < 0) {
					T tempItem =  tempList.get(t);
					tempList.set(t,  tempList.get(t + 1));
					tempList.set(t + 1, tempItem);
				}
				
				
			}
			
		}
		
		items.clear();
		items.addAll(tempList);
		
		
	}
	

}
