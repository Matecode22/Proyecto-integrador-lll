package models;

import java.util.Date;

public class BibliographicProduct {
    protected String identity;

    protected String name;

    protected Integer pageNumber;

    protected String publishDate;

    protected String cover;

    protected Double cost;

    private Integer totalReadPages;

    public BibliographicProduct() {
    }

    // This is a constructor method for the `BibliographicProduct` class that takes in a `String`
    // parameter called `identity`. It sets the `identity` field of the object to the value of the
    // `identity` parameter and initializes the `totalReadPages` field to 0. This constructor can be
    // used to create a new `BibliographicProduct` object with only the `identity` field set.
    public BibliographicProduct(String identity) {
        this.identity = identity;
        this.totalReadPages = 0;
    }

    public BibliographicProduct(String identity, String name, Integer pageNumber, String publishDate, String cover, Double cost) {
        this.identity = identity;
        this.name = name;
        this.pageNumber = pageNumber;
        this.publishDate = publishDate;
        this.cover = cover;
        this.cost = cost;
        this.totalReadPages = 0;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getTotalReadPages() {
        return totalReadPages;
    }

    public void setTotalReadPages(Integer totalReadPages) {
        this.totalReadPages = totalReadPages;
    }

    public void addNewRead(){
        this.totalReadPages++;
    }
}
