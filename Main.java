import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
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
		
		
		//bubbleSort(items);
		//insertionSort(items);
		//smartBubbleSort(items);
		
	}
	
	public <T> void parseData(List<Item> items) throws IOException {
		
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
	
	//bubble sort
	public void bubbleSort(ArrayList<Item> items) {
		
		for (int i = 0; i < items.size()-1; i++) {
			
			for (int t = 0; t < items.size() - i - 1; t++) {
				
				if (items.get(t+1).getItemNumber().compareTo(items.get(t).getItemNumber()) < 0) {
					Item tempItem = items.get(t);
					items.set(t, items.get(t + 1));
					items.set(t + 1, tempItem);
				}
				
			}
			
		}
		
		for (Item t: items) {
			System.out.println(t.getItemNumber());
		}
		
	}
	
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

}
