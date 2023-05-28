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
