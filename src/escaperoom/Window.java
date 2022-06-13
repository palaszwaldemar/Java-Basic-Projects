package escaperoom;

public class Window {
    private boolean isOpen;

    void useWindow() {
        if (!isOpen) {
            System.out.println("Okno zostalo otwarte");
            isOpen = true;
        } else {
            System.out.println("Okno zostalo zamkniete");
            isOpen = false;
        }
    }
}
