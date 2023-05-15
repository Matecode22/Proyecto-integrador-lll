public class User {
    private String name;
    private List<BibliographicProduct> bibliographicProducts;

    public User(String name) {
        this.name = name;
        this.bibliographicProducts = new ArrayList<BibliographicProduct>();
    }

    public String getName() {
        return name;
    }

    public List<BibliographicProduct> getBibliographicProducts() {
        return bibliographicProducts;
    }

    public void buyBibliographicProduct(BibliographicProduct product) {
        if (product != null && !bibliographicProducts.contains(product)) {
            bibliographicProducts.add(product);
            System.out.println(name + " ha comprado el producto bibliográfico " + product.getName() + ".");
        }
    }

    public void subscribeMagazine(Magazine magazine) {
        if (magazine != null && !bibliographicProducts.contains(magazine)) {
            bibliographicProducts.add(magazine);
            System.out.println(name + " se ha suscrito a la revista " + magazine.getName() + ".");
        }
    }

    public void simulateReadingSession() {
        System.out.println("Sesión de lectura iniciada para el usuario " + name + ".");
    }
}
