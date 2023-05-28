package enums;

public enum UserTypeEnum {
    PREMIUM("Premium"),
    REGULAR("Regular");
    private final String name;

    UserTypeEnum(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
