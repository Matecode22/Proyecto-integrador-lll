package enums;

public enum MagazinesCategoryEnum {
    VARIETIES("Variedades"),
    DESIGN("Diseño"),

    SCIENTIFIC("Científica");
    private final String name;

    MagazinesCategoryEnum(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
