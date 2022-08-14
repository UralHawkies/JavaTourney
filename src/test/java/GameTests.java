import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTests {

    Game game = new Game();

    @Test
    public void shouldWinFirst() {
        Player player1 = new Player(1, "Petya", 25);
        Player player2 = new Player(2, "Oleg", 10);

        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Petya", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinSecond() {
        Player player1 = new Player(1, "Petya", 25);
        Player player2 = new Player(2, "Oleg", 50);

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Petya", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldBeEqual() {
        Player player1 = new Player(1, "Petya", 50);
        Player player2 = new Player(2, "Oleg", 50);

        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Petya", "Oleg");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotFindPlayer() {
        Player player1 = new Player(1, "Petya", 50);
        Player player2 = new Player(2, "Oleg", 50);

        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotFoundException.class, ()  -> {
            game.round("Petya", "Oleggg");
        });
    }
}
