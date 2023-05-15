public class AutomaticObject{ 
private static String[] userNames = {"Juan", "Maria", "Pedro", "Ana", "Luis", "Laura", "Diego", "Carla", "Lucas", "Sofia"};
private static String[] bookNames = {"La Casa de los Espiritus", "Cien Años de Soledad", "El Extranjero", "1984", "El Amor en los Tiempos del Cólera", "Rayuela", "La Metamorfosis", "El Principito", "El Lobo Estepario", "La Ilíada"};
private static String[] bookAuthors = {"Isabel Allende", "Gabriel Garcia Marquez", "Albert Camus", "George Orwell", "Gabriel Garcia Marquez", "Julio Cortázar", "Franz Kafka", "Antoine de Saint-Exupéry", "Hermann Hesse", "Homero"};
private static double[] bookPrices = {12.99, 8.50, 5.99, 15.99, 10.50, 6.75, 7.99, 5.99, 9.99, 11.25};
private static String[] magazineNames = {"National Geographic", "Muy Interesante", "Vogue", "Time", "Forbes", "Elle", "Hola!", "Car and Driver", "Rolling Stone", "PC Gamer"};
private static int[] magazinePeriodicities = {30, 7, 30, 7, 7, 30, 7, 30, 7, 30};
private static double[] magazinePrices = {5.99, 3.50, 6.99, 4.99, 8.50, 7.75, 4.50, 6.99, 5.25, 4.99};

public static void generateObjects(Biblioteca biblioteca, int numUsers, int numBooks, int numMagazines) {
    
    Random random = new Random();
    
    // Generate users
    for (int i = 0; i < numUsers; i++) {
        int userType = random.nextInt(2) + 1;
        String userName = userNames[random.nextInt(userNames.length)];
        if (userType == 1) {
            RegularUser regularUser = new RegularUser(userName);
            biblioteca.registerUser(regularUser);
        } else if (userType == 2) {
            PremiumUser premiumUser = new PremiumUser(userName);
            biblioteca.registerUser(premiumUser);
        }
    }
    
    // Generate books
    for (int i = 0; i < numBooks; i++) {
        String bookName = bookNames[random.nextInt(bookNames.length)];
        String bookAuthor = bookAuthors[random.nextInt(bookAuthors.length)];
        double bookPrice = bookPrices[random.nextInt(bookPrices.length)];
        Book book = new Book(bookName, bookAuthor, bookPrice);
        biblioteca.registerBibliographicProduct(book);
    }
    
    // Generate magazines
    for (int i = 0; i < numMagazines; i++) {
        String magazineName = magazineNames[random.nextInt(magazineNames.length)];
        int magazinePeriodicity = magazinePeriodicities[random.nextInt(magazinePeriodicities.length)];
        double magazinePrice = magazinePrices[random.nextInt(magazinePrices.length)];
        Magazine magazine = new Magazine(magazineName, magazinePeriodicity, magazinePrice);
        biblioteca.registerBibliographicProduct(magazine);
    }
}

}

