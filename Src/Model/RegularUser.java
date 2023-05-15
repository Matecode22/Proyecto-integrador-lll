public class RegularUser extends User {
    public RegularUser(String name) {
        super(name);
    }

    @Override
    public void simulateReadingSession() {
        System.out.println("Sesión de lectura iniciada para el usuario regular " + getName() + ".");
    }
}
