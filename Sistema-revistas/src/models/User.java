package models;

import enums.UserTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;

    private String id;

    private String bondingDate;

    private UserTypeEnum userType;

    private List<UserRead<Book>> purchasedBooks = new ArrayList<>();

    private List<UserRead<Magazine>> purchasedMagazines = new ArrayList<>();

    public User() {
    }

    public User(String name, String id, String bondingDate, UserTypeEnum userType) {
        this.name = name;
        this.id = id;
        this.bondingDate = bondingDate;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBondingDate() {
        return bondingDate;
    }

    public void setBondingDate(String bondingDate) {
        this.bondingDate = bondingDate;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public List<UserRead<Book>> getPurchasedBooks() {
        return purchasedBooks;
    }

    public List<UserRead<Magazine>> getPurchasedMagazines() {
        return purchasedMagazines;
    }

    public void buyBook(UserRead<Book> book){
        if(getUserType() == UserTypeEnum.REGULAR){
            if(getPurchasedBooks().size() >= 5){
                System.out.println("You have reached the maximum limit, 5 books purchased.");
                return;
            }
        }
        this.purchasedBooks.add(book);
    }

    public void buyMagazine(UserRead<Magazine> magazine){
        if(getUserType() == UserTypeEnum.REGULAR){
            if(getPurchasedMagazines().size() >= 2){
                System.out.println("You have reached the maximum limit, 2 subscribed magazines.");
                return;
            }
        }
        this.purchasedMagazines.add(magazine);
    }

    public void cancelMagazine(Magazine magazine){
        this.purchasedMagazines.remove(magazine);
    }
}
