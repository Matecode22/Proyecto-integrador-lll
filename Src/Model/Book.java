public class Book extends BibliographicProduct {
    private String author;

    public Book(String name, String author, double price) {
        super(name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void modifyBook(String name, String author, double price) {
        setName(name);
        setAuthor(author);
        setPrice(price);
    }

    public void deleteBook() {
        setName(null);
        setAuthor(null);
        setPrice(0);
    }
}
