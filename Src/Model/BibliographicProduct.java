public abstract class BibliographicProduct {
    private String name;
    private double price;

    public BibliographicProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
