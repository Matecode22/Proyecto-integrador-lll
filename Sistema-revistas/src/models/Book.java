package models;

import enums.BooksGenereEnum;

public class Book extends BibliographicProduct{
    private String shortReview;

    private BooksGenereEnum genere;

    private Integer unitsSold;

    public Book() {
    }
    public Book(String identity) {
        super(identity);
    }

    public Book(String identity, String name, Integer pageNumber, String publishDate, String cover, Double cost, String shortReview,
                BooksGenereEnum genere, Integer unitsSold) {
        super(identity, name, pageNumber, publishDate, cover, cost);
        this.shortReview = shortReview;
        this.genere = genere;
        this.unitsSold = unitsSold;
    }

    public String getShortReview() {
        return shortReview;
    }

    public void setShortReview(String shortReview) {
        this.shortReview = shortReview;
    }

    public BooksGenereEnum getGenere() {
        return genere;
    }

    public void setGenere(BooksGenereEnum genere) {
        this.genere = genere;
    }

    public Integer getUnitsSold() {
        return unitsSold;
    }

    public void setUnitsSold(Integer unitsSold) {
        this.unitsSold = unitsSold;
    }

    @Override
    public String toString() {
        return "Identity: " + getIdentity() + "\n" +
                "Name: " + getName() + "\n" +
                "Page Number: " + getPageNumber() + "\n" +
                "Short Review: " + getShortReview() + "\n" +
                "Publish Date: " + getPublishDate() + "\n" +
                "Genere: " + getGenere() + "\n" +
                "URL: " + getCover() + "\n" +
                "Cost: " + getCost() + "\n" +
                "Units Sold: " + getUnitsSold() + "\n";
    }
}
