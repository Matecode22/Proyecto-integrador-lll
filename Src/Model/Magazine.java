public class Magazine extends BibliographicProduct {
    private int periodicity;

    public Magazine(String name, int periodicity, double price) {
        super(name, price);
        this.periodicity = periodicity;
    }

    public int getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(int periodicity) {
        this.periodicity = periodicity;
    }

    public void modifyMagazine(String name, int periodicity, double price) {
        setName(name);
        setPeriodicity(periodicity);
        setPrice(price);
    }

    public void deleteMagazine() {
        setName(null);
        setPeriodicity(0);
        setPrice(0);
    }
}


