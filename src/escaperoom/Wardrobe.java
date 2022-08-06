package escaperoom;

import java.util.Scanner;

public class Wardrobe extends Item{
    private final Code codeToOpenWardrobe;
    private final Key key;
    private boolean wasUse;
    private boolean isOpen;

    public Wardrobe(Code code, Key key) {
        super("Szafa");
        this.codeToOpenWardrobe = code;
        this.key = key;
    }

    @Override
    String use(Room room, Player player, Game game) {
        if (wasUse) {
            if(!isOpen) {
                isOpen = true;
                return "Otwierasz szafę";
            } else {
                isOpen = false;
                return "Zamykasz szafę";
            }
        }
        System.out.print("Podaj kod do szafy: ");//todo wprowadzanie kodu przez użytkownika. Nie powinno być w tej klasie obiektu typu Scanner oraz sout ale nie wiem jak zrobić inaczej
        Scanner scanner = new Scanner(System.in);
        String newCode = scanner.next();
        if (checkCode(newCode)) {
            player.addItem(key);
            isOpen = true;
            wasUse = true;
            return "Znajdujesz klucz do biurka.";
        }
        return "Błędny kod";
    }

    boolean checkCode (String newCode) {
        return newCode.equals(codeToOpenWardrobe.getCode());
    }
}
