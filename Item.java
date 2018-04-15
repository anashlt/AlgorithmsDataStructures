
public class Item  implements Comparable<Item>{
	
	
	String itemNumber;
	
	String name;
	
	int year;
	
	String theme;
	
	String subTheme;
	
	int pieces;
	
	int minifigures;
	
	String imageURL;
	
	double GBP_MSRP;
	
	double USD_MSRP;
	
	double CAD_MSRP;
	
	double EUR_MSRP;
	
	String packaging;
	
	String availability;
	
	
	
	public String getItemNumber() {
		return itemNumber;
	}

	public void setItemNumber(String itemNumber) {
		this.itemNumber = itemNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getSubTheme() {
		return subTheme;
	}

	public void setSubTheme(String subTheme) {
		this.subTheme = subTheme;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {
		this.pieces = pieces;
	}

	public int getMinifigures() {
		return minifigures;
	}

	public void setMinifigures(int minifigures) {
		this.minifigures = minifigures;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	public double getGBP_MSRP() {
		return GBP_MSRP;
	}

	public void setGBP_MSRP(double gBP_MSRP) {
		GBP_MSRP = gBP_MSRP;
	}

	public double getUSD_MSRP() {
		return USD_MSRP;
	}

	public void setUSD_MSRP(double uSD_MSRP) {
		USD_MSRP = uSD_MSRP;
	}

	public double getCAD_MSRP() {
		return CAD_MSRP;
	}

	public void setCAD_MSRP(double cAD_MSRP) {
		CAD_MSRP = cAD_MSRP;
	}

	public double getEUR_MSRP() {
		return EUR_MSRP;
	}

	public void setEUR_MSRP(double eUR_MSRP) {
		EUR_MSRP = eUR_MSRP;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public Item(String itemNumber, String name, int year, String theme , String subTheme, int pieces, int minifigures,
			String imageURL, double GBP_MSRP, double USD_MSRP, double CAD_MSRP, double EUR_MSRP, String packaging, String availability) {
		
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
	
	@Override
	/**
	 * @param Item o - the item that will be compared
	 */
	public int compareTo(Item o) {
		try {
			//parse item number to int in case it doesnt have letters such as A,B,C
			//for more accurate sorting later
			if (Integer.parseInt(this.itemNumber) < Integer.parseInt(o.itemNumber)) {
				return -1;
			} else if (Integer.parseInt(this.itemNumber) == Integer.parseInt(o.itemNumber)) {
				return 0;
			} else {
				return 1;
			}
			//if parsing fails, that means itemnumber contains
			//a letter and will throw an exception. Compare it as string
		} catch (NumberFormatException e) {
			if (this.itemNumber.compareTo(o.itemNumber) < 0) {
				return -1;
			} else if (this.itemNumber.compareTo(o.itemNumber) == 0) {
				return 0;
			} else {
				return 1;
			}
		}
	}
	

}
