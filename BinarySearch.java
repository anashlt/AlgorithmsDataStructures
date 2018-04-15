import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BinarySearch {
	
public <T extends Comparable<T>> T binSearch(Collection<T> items, T toSearch) {
		
		List<T> list = new LinkedList<T>();
		list.addAll(items);
		
		
		int low = 0;
		int high = list.size()-1;
		
		while (low <= high) {
			
			int mid = (low + high)/2;
			T value = list.get(mid);
			//compare search object and middle object
			int result = toSearch.compareTo(value);
			//if search value is smaller than comparee, take out right side
			if (result  < 0) {
				high = mid - 1;
			}
			//if search value is bigger than comparee, take out left side
			if (result > 0) {
				low = mid + 1;
			}
			//if search value is found result will be 0, return it
			if (toSearch.compareTo(value) == 0) {
				return value;
			}
			
		}
		
		return null;
		
		
	}

}
