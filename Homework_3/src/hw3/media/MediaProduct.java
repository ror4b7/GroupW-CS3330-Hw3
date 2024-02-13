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

    MediaProduct(String title, double price, int year, Genre genre) {
        this.title = title;
        this.Price = price;
        this.year = year;
        this.genre = genre;
    }
    

}
