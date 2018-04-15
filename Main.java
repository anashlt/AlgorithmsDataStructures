import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Main {
	
	public void run() throws IOException {
		
		
		
		List<Item> items = new LinkedList<Item>();
		List<Item> emptyItems = new LinkedList<Item>();
		
		//parse the data from legosets into a list of items
		parseData(items);
		
		//create datasets to test output
		List<String> list = new LinkedList<String>();
		
		Set<Item> set = new HashSet<Item>();
		
		Queue<String> queue = new PriorityQueue<String>();
		
		Stack<String> stack = new Stack<>();
		
		//fill datasets
		list.add("D");
		list.add("G");
		list.add("A");
		list.add("C");
		list.add("B");
		list.add("H");
		
		set.add(items.get(1)); 
		set.add(items.get(8)); 
		set.add(items.get(3)); 
		set.add(items.get(12));
		set.add(items.get(2));
		//set.add("4");
		
		queue.add("C");
		queue.add("A");
		queue.add("T");
		
		stack.push("Q");
		stack.push("C");
		stack.push("A");
		
		//bubble sort
		BubbleSort b = new BubbleSort();
		//b.bubbleSort(stack);
		
		//insertion sort
		InsertionSort is = new InsertionSort();
		//is.insertionSort(list);
		
		//smart bubble sort
		SmartBubbleSort sbs = new SmartBubbleSort();
		//sbs.smartBubbleSort(list);
		
		//quick sort
		QuickSort qs = new QuickSort();
		qs.quickSort(list, 0, list.size()-1);
		
		
		//output list
		int[] arr = new int[]{1,5,9,12};
		System.out.println(binsearch(arr,1));
		
	}
	
	public int binsearch(int []arr , int x) {
		
		int l = 0;
		int r = arr.length-1;
		
		while (l <= r) {
			
			int m = (l+r)/2;
			System.out.println(l);
			System.out.println(r);
			System.out.println(m);
			if (arr[m] == x) {
				return arr[m];
			}
			
			if (arr[m] < x) {
				l = m+1;
			}
			
			if (arr[m] > x) {
				r = m-1;
			}
			
		}
		
		return -1;
	}
	
	
	
	public static void main(String[] args) {
		try {
			new Main().run();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Using the CSV referenced library, parse the data from
	 * legosets into a list of objects
	 * @param items - the list that will be filled with lego data
	 * @throws IOException
	 */
	public <T extends Comparable<T>> void parseData(List<Item> items) throws IOException {
		
		Reader in = new FileReader("C://users/alpay/desktop/legosets.csv");
		
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
		
		for (CSVRecord r : records) {
			String item_number = r.get("Item_Number");
			String name = r.get("Name");
			int year = Integer.parseInt(r.get("Year"));
			String theme = r.get("Theme");
			String subtheme = r.get("Subtheme");
			int pieces = -1;
			
			if (r.get("Pieces").equals("NA")) {
				pieces = 0;
			} else {
				pieces = Integer.parseInt(r.get("Pieces"));
			}
			
			int minifigures = -1;
			
			if (r.get("Minifigures").equals("NA")) {
				minifigures = 0;
			} else {
				minifigures = Integer.parseInt(r.get("Minifigures"));
			}
			
			String image_URL = r.get("Image_URL");
			
			double GBP_MSRP = -1;
			
			if (r.get("GBP_MSRP").equals("NA")) {
				GBP_MSRP = 0.0;
			} else {
				GBP_MSRP = Double.parseDouble(r.get("GBP_MSRP"));
			}
			
			double USD_MSRP = -1;
			
			if (r.get("USD_MSRP").equals("NA")) {
				USD_MSRP = 0.0;
			} else {
				USD_MSRP = Double.parseDouble(r.get("USD_MSRP"));
			}
			
			double CAD_MSRP = -1;
			
			if (r.get("CAD_MSRP").equals("NA")) {
				CAD_MSRP = 0.0;
			} else {
				CAD_MSRP = Double.parseDouble(r.get("CAD_MSRP"));
			}
			
			double EUR_MSRP = -1;
			
			if (r.get("EUR_MSRP").equals("NA")) {
				EUR_MSRP = 0.0;
			} else {
				EUR_MSRP = Double.parseDouble(r.get("EUR_MSRP"));
			}
			
			String packaging = r.get("Packaging");
			String availability = r.get("Availability");
			
			
			items.add(new Item(item_number , name , year , theme , subtheme , pieces , minifigures , image_URL , GBP_MSRP , USD_MSRP , CAD_MSRP,
					 EUR_MSRP , packaging, availability));
		
			
		}
		
	}
	

}
