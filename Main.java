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
		
		List<String> list2 = new LinkedList<String>();
		
		List<String> list3 = new LinkedList<String>();
		
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
		
		list2.add("S");
		list2.add("C");
		list2.add("O");
		list2.add("G");
		
		list3.add("T");
		list3.add("E");
		list3.add("H");
		list3.add("Z");
		
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
		System.out.println("Bubble sorting stack...");
		b.bubbleSort(stack);
		System.out.println("Sorted stack:");
		for (String s: stack) {
			System.out.println(s);
		}
		
		//insertion sort
		InsertionSort is = new InsertionSort();
		System.out.println("insertion sorting list...");
		is.insertionSort(list);
		System.out.println("Sorted list:");
		for (String s: list) {
			System.out.println(s);
		}
		
		//smart bubble sort
		SmartBubbleSort sbs = new SmartBubbleSort();
		System.out.println("smart bubble sorting list...");
		sbs.smartBubbleSort(list2);
		for (String s: list2) {
			System.out.println(s);
		}
		
		//quick sort
		QuickSort qs = new QuickSort();
		qs.quickSort(list, 0, list.size()-1);
		
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
	public static <T extends Comparable<T>> void parseData(List<Item> items) throws IOException {
		
		//read the dataset from legosets directory
		Reader in = new FileReader(System.getProperty("user.dir") + "/src/lego.csv");
		
		//parse the data
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
		
		//put data into the items list
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
