package hw3.media;

public class MediaProduct
{
    protected String title; 
    protected double price; 
    protected int year; 
    protected Genre genre; 

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double Price) {
        this.price = Price;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return this.genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public MediaProduct(String title, double price, int year, Genre genre) {
        this.title = title;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }
    
    // Helper method returns the type of product based on the subclass
    private String getTypeOfProduct() {
    	String type = null;
    	if(this.getClass().getName().equals("hw3.media.VinylRecordProduct")) {
    		type = "Vinyl";
    	}
    	if(this.getClass().getName().equals("hw3.media.CDRecordProduct")) {
    		type = "CD";
    	}
    	if(this.getClass().getName().equals("hw3.media.TapeRecordProduct")) {
    		type = "Tape";
    	}
		return type;
    }

    // to string method to include the type of the subclass
	@Override
	public String toString() {
		return "MediaProduct [type="+ this.getTypeOfProduct() +", title=" + title + ", price=" + price + ", year=" + year + ", genre=" + genre + "]";
	}


}
