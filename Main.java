import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Main {
	
	public void run() throws IOException {
		
		
		
		

		
		
		List<Item> items = new LinkedList<Item>();
		
		parseData(items);
		
		
		for(Item i: items) {
			System.out.println(i.getCAD_MSRP());
		}		
		
		//bubbleSortItemNumber(items);
		//insertionSort(items);
		//smartBubbleSort(items);
		
	}
	
	
	//bubble sort
//	public <T extends Comparable<T>> void bubbleSortItemNumber(Collection<T>items) {
//		
//		for (int i = 0; i < items.size()-1; i++) {
//			
//			for (int t = 0; t < items.size() - i - 1; t++) {
//				
//				try {
//					
//					if (Integer.parseInt(items.get(t+1).getItemNumber()) < Integer.parseInt(items.get(t).getItemNumber())) {
//						T tempItem = items.get(t);
//						items.set(t, items.get(t + 1));
//						items.set(t + 1, tempItem);
//					}
//					
//				} catch (NumberFormatException e) {
//					if (items.get(t+1).getItemNumber().compareTo(items.get(t).getItemNumber()) < 0) {
//						T tempItem = items.get(t);
//						items.set(t, items.get(t + 1));
//						items.set(t + 1, tempItem);
//					}
//				}
//				
//			}
//			
//		}
//		
//		for (Item t: items) {
//			System.out.println(t.getItemNumber());
//		}
//		
//	}
	
	public void smartBubbleSort(ArrayList<Item>items) {
		
		boolean sorted = false;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < items.size()-1; i++) {
				
				for (int t = 0; t < items.size() - i - 1; t++) {
					
					if (items.get(t+1).getItemNumber().compareTo(items.get(t).getItemNumber()) < 0) {
						Item tempItem = items.get(t);
						items.set(t, items.get(t + 1));
						items.set(t + 1, tempItem);
						sorted = false;
					}
					
				}
				
			}
		}
		
		for (Item t: items) {
			System.out.println(t.getItemNumber());
		}
		
	}
	
	public void quickSort(ArrayList<Item>items, int start, int end) {
		

        int i = start;

        int j = end;


        if (j - i >= 1) {

            Item pivot = items.get(i);

            while (j > i)
            {

                while (items.get(i).getItemNumber().compareTo(pivot.getItemNumber()) <= 0 && i < end && j > i){
                    i++;
                }

                while (items.get(j).getItemNumber().compareTo(pivot.getItemNumber()) >= 0 && j > start && j >= i){
                    j--;
                }

                if (j > i) {
                    swap(items, i, j);
                }
            }

            swap(items, start, j);

            quickSort(items, start, j - 1);

            quickSort(items, j + 1, end);
		
        }
	}
	
	public void swap(ArrayList<Item> items , int i , int j) {
		Item temp = items.get(i);
		items.set(i, items.get(j));
		items.set(j, temp);
	}
        
	
	public void insertionSort(ArrayList<Item> items) {
		
		for(int i = 1; i < items.size(); i++)  {
		    Item key = items.get(i);
		    int j = i - 1;

		    while (j >= 0 && key.getItemNumber().compareTo(items.get(j).getItemNumber()) < 0) {
		        items.set(j + 1, items.get(j));
		        j--;
		    }
		    items.set(j + 1, key);
		}
		
		for (Item t: items) {
			System.out.println(t.getItemNumber());
		}
		
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
	
	public <T extends Comparable<T>> void parseData(List<Item> items) throws IOException {
		
		Reader in = new FileReader("C://users/alpay/desktop/legosets.csv");
		
		Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
		
		for (CSVRecord r : records) {
			
			T item_number = (T)r.get("Item_Number");
			T name = (T)r.get("Name");
			T year = (T)r.get("Year");
			T theme = (T)r.get("Theme");
			T subtheme = (T)r.get("Subtheme");
			
			T pieces = (T)r.get("Pieces");
			T minifigures = (T)r.get("Minifigures");
			
			
			T image_URL = (T)r.get("Image_URL");
			T GBP_MSRP = (T)r.get("GBP_MSRP");
			T USD_MSRP = (T)r.get("USD_MSRP");
			T CAD_MSRP = (T)r.get("CAD_MSRP");
			T EUR_MSRP = (T)r.get("EUR_MSRP");
			
			T packaging = (T) r.get("Packaging");
			T availability = (T)r.get("Availability");
			
			
			
			items.add(new Item(item_number , name , year , theme , subtheme , pieces , minifigures , image_URL , GBP_MSRP , USD_MSRP , CAD_MSRP,
					 EUR_MSRP , packaging, availability));
		
			
		}
		
	}
	

}
