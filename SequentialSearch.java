import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SequentialSearch <T extends Comparable<T>> {
	
	public <T> T seqSearch(Collection<T> items, T toSearch) {
		
		List<T> list = new LinkedList<T>();
		list.addAll(items);
		
		for (T t : list) {
			if (t.equals(toSearch)) {
				return t;
			}
		}
		
		return null;
		
		
	}
	
}
