package zbijak;// todo: 31.08.2022 dokończyć

public class Launcher {
    public static void main(String[] args) {
        Game game = new Game();
        game.printBoard();
        // - wyświetlenie planszy 10x10
        // - pojawienie się 4 graczy w różnych miejscach
        // - sterowanie W, A, S, D
        // - nie można wypaść poza plansze
        // - 3 graczy to npc, poruszają sie losowo
        // - wejscie na pole innego gracza powoduje zbicie
        // - komputer rusza się co dwa ruchy gracza
        // - gra kończy się jak gracz zbije wszystkich lub sam zostanie zbity
    }
}

