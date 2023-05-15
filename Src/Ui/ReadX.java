import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            System.out.println("Bienvenido a la Biblioteca!");
            System.out.println("1. Registrar un usuario");
            System.out.println("2. Registrar un producto bibliográfico");
            System.out.println("3. Comprar un libro");
            System.out.println("4. Suscribirse a una revista");
            System.out.println("5. Simular una sesión de lectura");
            System.out.println("6. Ver mi biblioteca");
            System.out.println("7. Generar reportes");
            System.out.println("0. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el tipo de usuario (1: Regular, 2: Premium):");
                    int tipoUsuario = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre del usuario:");
                    String nombreUsuario = scanner.nextLine();
                    if (tipoUsuario == 1) {
                        RegularUser regularUser = new RegularUser(nombreUsuario);
                        biblioteca.registerUser(regularUser);
                    } else if (tipoUsuario == 2) {
                        PremiumUser premiumUser = new PremiumUser(nombreUsuario);
                        biblioteca.registerUser(premiumUser);
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el tipo de producto bibliográfico (1: Libro, 2: Revista):");
                    int tipoProducto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre del producto:");
                    String nombreProducto = scanner.nextLine();
                    if (tipoProducto == 1) {
                        System.out.println("Ingrese el autor del libro:");
                        String autor = scanner.nextLine();
                        System.out.println("Ingrese el precio del libro:");
                        double precio = scanner.nextDouble();
                        scanner.nextLine();
                        Book book = new Book(nombreProducto, autor, precio);
                        biblioteca.registerBibliographicProduct(book);
                    } else if (tipoProducto == 2) {
                        System.out.println("Ingrese la periodicidad de la revista (en días):");
                        int periodicidad = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Ingrese el precio de la revista:");
                        double precio = scanner.nextDouble();
                        scanner.nextLine();
                        Magazine magazine = new Magazine(nombreProducto, periodicidad, precio);
                        biblioteca.registerBibliographicProduct(magazine);
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el nombre del usuario que quiere comprar el libro:");
                    String nombreUsuarioCompra = scanner.nextLine();
                    System.out.println("Ingrese el nombre del libro que quiere comprar:");
                    String nombreLibroCompra = scanner.nextLine();
                    User userCompra = biblioteca.findUser(nombreUsuarioCompra);
                    Book libroCompra = biblioteca.findBook(nombreLibroCompra);
                    if (userCompra != null && libroCompra != null) {
                        userCompra.buyBibliographicProduct(libroCompra);
                    } else {
                        System.out.println("Usuario o libro no encontrados.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese el nombre del usuario que quiere suscribirse a la revista:");
                    String nombreUsuarioSuscripcion = scanner.nextLine();
                   
                    case 4:
                    System.out.println("Ingrese el nombre del usuario que quiere suscribirse a la revista:");
                    String nombreUsuarioSuscripcion = scanner.nextLine();
                    System.out.println("Ingrese el nombre de la revista a la que quiere suscribirse:");
                    String nombreRevistaSuscripcion = scanner.nextLine();
                    User userSuscripcion = biblioteca.findUser(nombreUsuarioSuscripcion);
                    Magazine revistaSuscripcion = biblioteca.findMagazine(nombreRevistaSuscripcion);
                    if (userSuscripcion != null && revistaSuscripcion != null) {
                        userSuscripcion.subscribeMagazine(revistaSuscripcion);
                    } else {
                        System.out.println("Usuario o revista no encontrados.");
                    }
                    break;
                    case 5:
                    System.out.println("Ingrese el nombre del usuario que quiere simular una sesión de lectura:");
                    String nombreUsuarioSesion = scanner.nextLine();
                    User userSesion = biblioteca.findUser(nombreUsuarioSesion);
                    if (userSesion instanceof RegularUser) {
                        ((RegularUser) userSesion).simulateReadingSession();
                    } else if (userSesion instanceof PremiumUser) {
                        ((PremiumUser) userSesion).simulateReadingSession();
                    } else {
                        System.out.println("Usuario no encontrado o no es un usuario regular o premium.");
                    }
                    break;
                    case 6:
                    System.out.println("Ingrese el nombre del usuario:");
                    String nombreUsuarioBiblioteca = scanner.nextLine();
                    User userBiblioteca = biblioteca.findUser(nombreUsuarioBiblioteca);
                    if (userBiblioteca != null) {
                        System.out.println("Biblioteca de " + userBiblioteca.getNombre() + ":");
                        for (BibliographicProduct product : userBiblioteca.getLibrary()) {
                            System.out.println(product.getNombre());
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                    case 7:
                    System.out.println("1. Generar reporte de usuarios");
                    System.out.println("2. Generar reporte de productos bibliográficos");
                    int opcionReporte = scanner.nextInt();
                    if (opcionReporte == 1) {
                        ReportGenerator.generateUserReport(biblioteca.getUsuarios());
                    } else if (opcionReporte == 2) {
                        ReportGenerator.generateBibliographicProductReport(biblioteca.getProductosBibliograficos());
                    } else {
                        System.out.println("Opción no válida.");
                    }
                    break;
                }                    
            }              

        }
}           