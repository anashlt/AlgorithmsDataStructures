import java.util.List;

public class BubbleSort <T extends Comparable<T>>  {
	
	public BubbleSort () {
		
		
	}
	
	public <T extends Comparable<T>> void bubbleSort(List<T> items) {
		
		for (int i = 0; i < items.size()-1; i++) {
			System.out.println(i);
			for (int t = 0; t < items.size() - i - 1; t++) {
				
			
				if (items.get(t+1).compareTo(items.get(t)) < 0) {
					T tempItem = items.get(t);
					items.set(t, items.get(t + 1));
					items.set(t + 1, tempItem);
				}
				
				
			}
			
		}
		
		
	}
	

}
