import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class Item <T extends Comparable<T>>{
	
	T itemNumber;
	
	T name;
	
	T year;
	
	T theme;
	
	T subTheme;
	
	T pieces;
	
	T minifigures;
	
	T imageURL;
	
	T GBP_MSRP;
	
	T USD_MSRP;
	
	T CAD_MSRP;
	
	T EUR_MSRP;
	
	T packaging;
	
	T availability;
	
	

	public Item(T itemNumber, T name, T year, T theme , T subTheme, T pieces, T minifigures,
			T imageURL, T GBP_MSRP, T USD_MSRP, T CAD_MSRP, T EUR_MSRP, T packaging, T availability) {
		
		this.itemNumber = itemNumber;
		this.name = name;
		this.year = year;
		this.theme = theme;
		this.subTheme = subTheme;
		this.pieces = pieces;
		this.minifigures = minifigures;
		this.imageURL = imageURL;
		this.GBP_MSRP = GBP_MSRP;
		this.USD_MSRP = USD_MSRP;
		this.CAD_MSRP = CAD_MSRP;
		this.EUR_MSRP = EUR_MSRP;
		this.packaging = packaging;
		this.availability = availability;
		
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
	
	public T getItemNumber() {
		return itemNumber;
	}



	public void setItemNumber(T itemNumber) {
		this.itemNumber = itemNumber;
	}



	public T getName() {
		return name;
	}



	public void setName(T name) {
		this.name = name;
	}



	public T getYear() {
		return year;
	}



	public void setYear(T year) {
		this.year = year;
	}



	public T getTheme() {
		return theme;
	}



	public void setTheme(T theme) {
		this.theme = theme;
	}



	public T getSubTheme() {
		return subTheme;
	}



	public void setSubTheme(T subTheme) {
		this.subTheme = subTheme;
	}



	public T getPieces() {
		return pieces;
	}



	public void setPieces(T pieces) {
		this.pieces = pieces;
	}



	public T getMinifigures() {
		return minifigures;
	}



	public void setMinifigures(T minifigures) {
		this.minifigures = minifigures;
	}



	public T getImageURL() {
		return imageURL;
	}



	public void setImageURL(T imageURL) {
		this.imageURL = imageURL;
	}



	public T getGBP_MSRP() {
		return GBP_MSRP;
	}



	public void setGBP_MSRP(T gBP_MSRP) {
		GBP_MSRP = gBP_MSRP;
	}



	public T getUSD_MSRP() {
		return USD_MSRP;
	}



	public void setUSD_MSRP(T uSD_MSRP) {
		USD_MSRP = uSD_MSRP;
	}



	public T getCAD_MSRP() {
		return CAD_MSRP;
	}



	public void setCAD_MSRP(T cAD_MSRP) {
		CAD_MSRP = cAD_MSRP;
	}



	public T getEUR_MSRP() {
		return EUR_MSRP;
	}



	public void setEUR_MSRP(T eUR_MSRP) {
		EUR_MSRP = eUR_MSRP;
	}



	public T getPackaging() {
		return packaging;
	}



	public void setPackaging(T packaging) {
		this.packaging = packaging;
	}



	public T getAvailability() {
		return availability;
	}



	public void setAvailability(T availability) {
		this.availability = availability;
	}
	
	

}
