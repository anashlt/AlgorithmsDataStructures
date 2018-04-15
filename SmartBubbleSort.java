import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SmartBubbleSort <T extends Comparable<T>>{
	
	/**
	 * 
	 * @param items - collection that will be smart bubble sorted
	 */
	public <T extends Comparable<T>> void smartBubbleSort(Collection<T> items ) {
		
		List<T> tempList = new LinkedList<T>();
		tempList.addAll(items);
		
		//check if its sorted with boolean
		boolean sorted = false;
		//loop while not sorted
		while (!sorted) {
			sorted = true;
			//perform bubble sort
			for (int i = 0; i < tempList.size()-1; i++) {
				
				for (int t = 0; t < tempList.size() - i - 1; t++) {
					
					//cast items to list of T
					if (tempList.get(t+1).compareTo(tempList.get(t)) < 0) {
						T tempItem = tempList.get(t);
						tempList.set(t, tempList.get(t + 1));
						tempList.set(t + 1, tempItem);
						sorted = false;
					}
					
				}
				
			}
		}
		
		items.clear();
		items.addAll(tempList);
		
	}

}
