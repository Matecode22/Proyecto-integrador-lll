public class PremiumUser extends User {
    public PremiumUser(String name) {
        super(name);
    }

    @Override
    public void simulateReadingSession() {
        System.out.println("Sesión de lectura iniciada para el usuario premium " + getName() + ".");
    }
}
