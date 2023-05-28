import enums.BooksGenereEnum;
import enums.MagazinesCategoryEnum;
import enums.UserTypeEnum;
import models.*;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final List<Book> books = new ArrayList<>();

    private static final User currentUser = new User("Juan", "10000", "20-02-2023", UserTypeEnum.PREMIUM);

    private static final List<Magazine> magazines = new ArrayList<>();

    public static void main(String[] args) {
        try {
            int option;

            do {
                System.out.println("=====================MENU=====================");
                System.out.println("1. Register a bibliographic product");
                System.out.println("2. Modify a bibliographic product");
                System.out.println("3. Delete a bibliographic product");
                System.out.println("4. Enter my library");
                System.out.println("5. Reports");
                System.out.println("6. Buy Product");


                System.out.println("9. Exit");
                System.out.print("Choose an option: ");
                option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        registerBibliographicProduct();
                        break;
                    case 2:
                        modifyBibliographicProduct();
                        break;
                    case 3:
                        deleteBibliographicProduct();
                        break;
                    case 4:
                        enterLibrary();
                        break;
                    case 5:
                        showReports();
                        break;
                    case 6:
                        buyProduct();
                    default:

                }
            } while (option != 9);

            System.out.println("thanks for use the system");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An unexpected error has occurred, please try again later");
        }
    }

    private static void registerBibliographicProduct() {
        int option;

        do {
            System.out.println("1. Book");
            System.out.println("2. Magazine");
            System.out.println("3. Go back");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    createBook(null);
                    option = 3;
                    break;
                case 2:
                    createMagazine(null);
                    option = 3;
                    break;
                case 3:
                    System.out.println("You choose an invalid option");
                    break;
                default:
                    registerBibliographicProduct();
            }
        } while (option != 3);
    }

    private static BibliographicProduct createBibliographicProduct(String identityOld) {
        String identity;

        if (identityOld == null) {
            System.out.println("Enter identity");
            identity = scanner.nextLine();

            if (identity.length() != 3) {
                System.out.println("identity must be 3 characters");
                return null;
            }
        } else {
            identity = identityOld;
        }


        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter page number");
        String _pageNumber = scanner.nextLine();
        Integer pageNumber = Integer.valueOf(_pageNumber);

        System.out.println("Enter publish date");
        String publishDate = scanner.nextLine();

        System.out.println("Enter cover");
        String cover = scanner.nextLine();

        System.out.println("Enter cost");
        Double cost = Double.valueOf(scanner.nextLine());

        return new BibliographicProduct(identity, name, pageNumber, publishDate, cover, cost);
    }

    private static void createBook(String identityOld) {
        BibliographicProduct bibliographicProduct = createBibliographicProduct(identityOld);

        if (bibliographicProduct == null) {
            return;
        }

        System.out.println("Enter book short review");
        String shortReview = scanner.nextLine();

        System.out.println("Enter book units sold");
        Integer unitsSold = Integer.valueOf(scanner.nextLine());

        BooksGenereEnum genere = null;

        int option;

        do {
            System.out.println("1. Science FICTION");
            System.out.println("2. Fantasy");
            System.out.println("3. History Novel");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> genere = BooksGenereEnum.SCIENCE_FICTION;
                case 2 -> genere = BooksGenereEnum.FANTASY;
                case 3 -> genere = BooksGenereEnum.HISTORY_NOVEL;
                default -> System.out.println("You choose an invalid option");
            }
        } while (genere == null);

        books.add(new Book(bibliographicProduct.getIdentity(),
                bibliographicProduct.getName(),
                bibliographicProduct.getPageNumber(),
                bibliographicProduct.getPublishDate(),
                bibliographicProduct.getCover(), bibliographicProduct.getCost(), shortReview, genere, unitsSold));
    }

    private static void createMagazine(String identityOld) {
        BibliographicProduct bibliographicProduct = createBibliographicProduct(identityOld);

        if (bibliographicProduct == null) {
            return;
        }

        System.out.println("Enter magazine active subscription");
        Integer activeSubs = Integer.valueOf(scanner.nextLine());

        MagazinesCategoryEnum category = null;

        int option;

        do {
            System.out.println("1. Varieties");
            System.out.println("2. Design");
            System.out.println("3. Scientific");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> category = MagazinesCategoryEnum.VARIETIES;
                case 2 -> category = MagazinesCategoryEnum.DESIGN;
                case 3 -> category = MagazinesCategoryEnum.SCIENTIFIC;
                default -> System.out.println("You choose an invalid option");
            }
        } while (category == null);

        magazines.add(new Magazine(bibliographicProduct.getIdentity(),
                bibliographicProduct.getName(),
                bibliographicProduct.getPageNumber(),
                bibliographicProduct.getPublishDate(),
                bibliographicProduct.getCover(), bibliographicProduct.getCost(), category, activeSubs));
    }

    private static void modifyBibliographicProduct() {
        int option;

        do {
            System.out.println("1. Book");
            System.out.println("2. Magazine");
            System.out.println("3. Go back");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    updateBook();
                    option = 3;
                    break;
                case 2:
                    updateMagazine();
                    option = 3;
                    break;
                case 3:
                    System.out.println("You choose an invalid option");
                    break;
                default:
                    modifyBibliographicProduct();
            }
        } while (option != 3);
    }

    private static Book getBookByIdentity(String identity) {
        Book book = null;

        for (Book value : books) {
            if (Objects.equals(value.getIdentity(), identity)) {
                book = value;
                break;
            }
        }

        return book;
    }

    private static Magazine getMagazineByIdentity(String identity) {
        Magazine magazine = null;

        for (Magazine value : magazines) {
            if (Objects.equals(value.getIdentity(), identity)) {
                magazine = value;
                break;
            }
        }

        return magazine;
    }

    private static void updateBook() {
        System.out.println("Enter the identity of the book you want to update");
        String identity = scanner.nextLine();

        if (identity.length() != 3) {
            System.out.println("identity must be 3 characters");
            return;
        }

        Book book = getBookByIdentity(identity);

        if (book == null) {
            System.out.println("the book has not been found");
            return;
        }

        int positionBook = books.indexOf(book);

        createBook(identity);

        books.remove(positionBook);
    }

    private static void updateMagazine() {
        System.out.println("Enter the identity of the magazine you want to update");
        String identity = scanner.nextLine();

        if (identity.length() != 3) {
            System.out.println("identity must be 3 characters");
            return;
        }

        Magazine magazine = getMagazineByIdentity(identity);

        if (magazine == null) {
            System.out.println("the magazine has not been found");
            return;
        }

        int positionBook = magazines.indexOf(magazine);

        createMagazine(identity);

        magazines.remove(positionBook);
    }

    private static void deleteBibliographicProduct() {
        int option;

        do {
            System.out.println("1. Book");
            System.out.println("2. Magazine");
            System.out.println("3. Go back");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    deleteBook();
                    option = 3;
                    break;
                case 2:
                    deleteMagazine();
                    option = 3;
                    break;
                case 3:
                    System.out.println("You choose an invalid option");
                    break;
                default:
                    modifyBibliographicProduct();
            }
        } while (option != 3);
    }

    private static void deleteBook() {
        System.out.println("Enter the identity of the book you want to update");
        String identity = scanner.nextLine();

        if (identity.length() != 3) {
            System.out.println("identity must be 3 characters");
            return;
        }

        Book book = getBookByIdentity(identity);

        if (book == null) {
            System.out.println("the book has not been found");
            return;
        }

        books.remove(book);
    }

    private static void deleteMagazine() {
        System.out.println("Enter the identity of the magazine you want to update");
        String identity = scanner.nextLine();

        if (identity.length() != 3) {
            System.out.println("identity must be 3 characters");
            return;
        }

        Magazine magazine = getMagazineByIdentity(identity);

        if (magazine == null) {
            System.out.println("the magazine has not been found");
            return;
        }

        magazines.remove(magazine);
    }

    private static void enterLibrary() {
        int option;
        int page = 0;

        do {
            try {
                showLibrary(page);
            } catch (Exception e) {
                if (e.getMessage() == "error defined start table") {
                    if (page > 0) {
                        page--;
                    }
                    System.out.println("can't go to the next page, buy more books");
                }
            }

            System.out.println("1. Enter the coordinate (x, y)");
            System.out.println("2. Enter the bibliographic product identity");
            System.out.println("3. Next page");
            System.out.println("4. Preview page");
            System.out.println("5. Go back");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                case 2:
                    System.out.println("Enter identity");
                    String identity = scanner.nextLine();

                    if (identity.length() != 3) {
                        System.out.println("identity must be 3 characters");
                        return;
                    }

                    Book book = getBookByIdentity(identity);

                    Magazine magazine = getMagazineByIdentity(identity);

                    readBook(new UserRead<>(0, book), new UserRead<>(0, magazine));
                    break;
                case 3:
                    page++;
                    break;
                case 4:
                    if (page > 0) {
                        page--;
                    }
                    break;
                default:
                    System.out.println("You choose an invalid option");
            }
        } while (option != 5);
    }

    private static void showLibrary(int page) throws Exception {
        int limitCellTable = 25;

        List<String> bibliographicProductsIdentityBook = currentUser.getPurchasedBooks()
                .stream().map(oItem -> oItem.getBibliographicProduct().getIdentity()).toList();

        List<String> bibliographicProductsIdentityMagazine = currentUser.getPurchasedMagazines()
                .stream().map(oItem -> oItem.getBibliographicProduct().getIdentity()).toList();

        List<String> bibliographicProductsIdentity = new ArrayList<>(bibliographicProductsIdentityBook);

        bibliographicProductsIdentity.addAll(bibliographicProductsIdentityMagazine);

        int start = page * limitCellTable;

        if (start > bibliographicProductsIdentity.size()) {
            throw new Exception("error defined start table");
        }

        int limit = start + limitCellTable;

        if (limit > bibliographicProductsIdentity.size()) {
            limit = bibliographicProductsIdentity.size();
        }

        bibliographicProductsIdentity = bibliographicProductsIdentity.subList(start, limit);

        int addCellBlank = limitCellTable - bibliographicProductsIdentity.size();

        for (int a = 0; a < addCellBlank; a++) {
            bibliographicProductsIdentity.add("___");
        }

        int row = 0;
        System.out.println(currentUser.getName() + "'s Library");
        System.out.println("      0  |  1  |  2  |  3  |  4  |");
        for (int i = 0; i < bibliographicProductsIdentity.size(); i++) {
            if ((i % 5) == 0) {
                if (row == 5) {
                    break;
                }
                if (i != 0) {
                    System.out.println();
                }
                System.out.printf("%03d", row);
                System.out.print("|");
                row++;
            }
            System.out.print(" " + bibliographicProductsIdentity.get(i) + " |");
        }
        System.out.println();
    }

    private static void readBook(UserRead<Book> book, UserRead<Magazine> magazine) {
        int option;
        do {
            System.out.println("Reading session in progress");
            if (book != null) {
                System.out.println("Reading: " + book.getBibliographicProduct().getName());
            } else {
                System.out.println("Reading: " + magazine.getBibliographicProduct().getName());
            }

            if (book != null) {
                System.out.println("Reading: " + book.getPagesRead() + " of " + book.getBibliographicProduct().getPageNumber());

                if ((book.getBibliographicProduct().getPageNumber() % 20) == 0) {
                    showAds();
                }
            } else {
                System.out.println("Reading: " + magazine.getPagesRead() + " of " + magazine.getBibliographicProduct().getPageNumber());

                if ((magazine.getBibliographicProduct().getPageNumber() % 20) == 0) {
                    showAds();
                }
            }

            System.out.println("1. Go to preview page");
            System.out.println("2. Go to next page");
            System.out.println("3. Go back");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    if (book != null) {
                        book.previewPage();
                    } else {
                        magazine.previewPage();
                    }
                case 2:
                    if (book != null) {
                        if (book.getBibliographicProduct().getPageNumber() >= book.getPagesRead()) {
                            book.getBibliographicProduct().addNewRead();
                            book.nextPage();
                        }
                    } else {
                        if (magazine.getBibliographicProduct().getPageNumber() >= magazine.getPagesRead()) {
                            magazine.nextPage();
                        }
                    }
                    break;
                default:
                    System.out.println("You choose an invalid option");
            }
        } while (option != 3);
    }

    public static void showAds() {
        System.out.println("https://i.ytimg.com/vi/1B-CHOQuPNU/maxresdefault.jpg");
        System.out.println("https://mumu-global.fp.ps.easebar.com/file/6158f20d3fb8da52276999b4crW31bdK02");
        System.out.println("https://files.rcnradio.com/2021-03/exito_0.jpg");
    }

    private static void showReports() {
        int option;

        do {
            System.out.println("1. Total pages Read");
            System.out.println("2. Most read books by genre and category");
            System.out.println("3. Top 5 most read books and magazines");
            System.out.println("4. Books sold by genere");
            System.out.println("5. Active subscriptions for magazines and the total paid");
            System.out.println("6. Go back");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1:
                    Integer booksTotalPagesRead = 0;
                    for (int i = 0; i < books.size(); i++) {
                        booksTotalPagesRead += books.get(i).getTotalReadPages();
                    }

                    Integer magazineTotalPagesRead = 0;
                    for (int i = 0; i < magazines.size(); i++) {
                        magazineTotalPagesRead += magazines.get(i).getTotalReadPages();
                    }

                    System.out.println("Books: " + booksTotalPagesRead);
                    System.out.println("Magazine: " + magazineTotalPagesRead);
                    break;
                case 2:

                    HashMap<String, Integer> booksDiccionary = new HashMap<>();

                    booksDiccionary.put(BooksGenereEnum.SCIENCE_FICTION.getName(), 0);
                    booksDiccionary.put(BooksGenereEnum.FANTASY.getName(), 0);
                    booksDiccionary.put(BooksGenereEnum.HISTORY_NOVEL.getName(), 0);

                    for (int i = 0; i < books.size(); i++) {
                        Integer totalOld = booksDiccionary.get(books.get(i).getGenere().getName());
                        booksDiccionary.put(books.get(i).getGenere().getName(),
                                totalOld + books.get(i).getTotalReadPages());
                    }

                    booksDiccionary.entrySet().stream().sorted((oItem1, oItem2) -> {
                        if (oItem1.getValue() > oItem2.getValue()) {
                            return 1;
                        }

                        if (oItem1.getValue() < oItem2.getValue()) {
                            return -1;
                        }

                        return 0;
                    }).forEach((oItem) -> {
                        System.out.println(oItem.getKey() + ": " + oItem.getValue());
                    });

                    HashMap<String, Integer> magazineDiccionary = new HashMap<>();

                    magazineDiccionary.put(MagazinesCategoryEnum.SCIENTIFIC.getName(), 0);
                    magazineDiccionary.put(MagazinesCategoryEnum.VARIETIES.getName(), 0);
                    magazineDiccionary.put(MagazinesCategoryEnum.DESIGN.getName(), 0);

                    for (int i = 0; i < magazines.size(); i++) {
                        Integer totalOld = magazineDiccionary.get(magazines.get(i).getCategory().getName());
                        booksDiccionary.put(magazines.get(i).getCategory().getName(),
                                totalOld + magazines.get(i).getTotalReadPages());
                    }

                    magazineDiccionary.entrySet().stream().sorted((oItem1, oItem2) -> {
                        if (oItem1.getValue() > oItem2.getValue()) {
                            return 1;
                        }

                        if (oItem1.getValue() < oItem2.getValue()) {
                            return -1;
                        }

                        return 0;
                    }).forEach((oItem) -> {
                        System.out.println(oItem.getKey() + ": " + oItem.getValue());
                    });

                    break;
                case 3:
                    books.stream().sorted((oItem1, oItem2) -> {
                        if (oItem1.getTotalReadPages() > oItem2.getTotalReadPages()) {
                            return 1;
                        }

                        if (oItem1.getTotalReadPages() < oItem2.getTotalReadPages()) {
                            return -1;
                        }

                        return 0;
                    }).toList().subList(0, Math.min(books.size(), 5)).forEach((oItem) -> {
                        System.out.println(oItem.getName() + ": " + oItem.getTotalReadPages());
                    });

                    magazines.stream().sorted((oItem1, oItem2) -> {
                        if (oItem1.getTotalReadPages() > oItem2.getTotalReadPages()) {
                            return 1;
                        }

                        if (oItem1.getTotalReadPages() < oItem2.getTotalReadPages()) {
                            return -1;
                        }

                        return 0;
                    }).toList().subList(0, Math.min(magazines.size(), 5)).forEach((oItem) -> {
                        System.out.println(oItem.getName() + ": " + oItem.getTotalReadPages());
                    });
                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    System.out.println("You choose an invalid option");
            }
        } while (option != 6);
    }

    private static void buyProduct() {
        System.out.println("Enter identity");
        String identity = scanner.nextLine();

        if (identity.length() != 3) {
            System.out.println("identity must be 3 characters");
            return;
        }

        Book book = getBookByIdentity(identity);

        Magazine magazine = getMagazineByIdentity(identity);

        if (book != null) {
            book.setUnitsSold(book.getUnitsSold() + 1);
            currentUser.buyBook(new UserRead<>(0, book));
        } else if (magazine != null) {
            magazine.setActiveSubs(magazine.getActiveSubs() + 1);
            currentUser.buyMagazine(new UserRead<>(0, magazine));
        } else {
            System.out.println("the entered product has not been found");
        }
    }
}