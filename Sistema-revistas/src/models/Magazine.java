package models;

import enums.MagazinesCategoryEnum;

public class Magazine extends BibliographicProduct {
    private MagazinesCategoryEnum category;
    private Integer activeSubs;

    public Magazine() {
    }

    public Magazine(String identity, String name, Integer pageNumber, String publishDate, String cover, Double cost, MagazinesCategoryEnum genere, Integer activeSubs) {
        super(identity, name, pageNumber, publishDate, cover, cost);
        this.category = genere;
        this.activeSubs = activeSubs;
    }

    public MagazinesCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(MagazinesCategoryEnum category) {
        this.category = category;
    }

    public Integer getActiveSubs() {
        return activeSubs;
    }

    public void setActiveSubs(Integer activeSubs) {
        this.activeSubs = activeSubs;
    }
}
