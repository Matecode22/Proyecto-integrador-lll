package models;


public class UserRead<T> {
    private Integer pagesRead;
    private T bibliographicProduct;

    public UserRead() {
    }

    public UserRead(Integer pagesRead, T bibliographicProduct) {
        this.pagesRead = pagesRead;
        this.bibliographicProduct = bibliographicProduct;
    }

    public Integer getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(Integer pagesRead) {
        this.pagesRead = pagesRead;
    }

    public T getBibliographicProduct() {
        return bibliographicProduct;
    }

    public void setBibliographicProduct(T bibliographicProduct) {
        this.bibliographicProduct = bibliographicProduct;
    }

    public void previewPage(){
        if(this.pagesRead != 0){
            this.pagesRead--;
        }
    }

    public void nextPage(){
        this.pagesRead++;
    }
}
