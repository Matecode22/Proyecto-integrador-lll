package enums;

public enum BooksGenereEnum {
    SCIENCE_FICTION("Ciencia Ficción"),
    FANTASY("Fantasia"),

    HISTORY_NOVEL("Novela histórica");
    private final String name;

    BooksGenereEnum(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
