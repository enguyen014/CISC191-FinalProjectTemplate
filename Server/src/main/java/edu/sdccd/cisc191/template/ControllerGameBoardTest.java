import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControllerGameBoardTest {

    @Test
    void testInitializeGameBoard() {
        ControllerGameBoard controller = new ControllerGameBoard();
        ModelGameBoard model = controller.modelGameBoard;

        // Check that the game board is initialized with the correct number of fish and guesses
        assertEquals(3, model.getFishRemaining());
        assertEquals(10, model.getGuessesRemaining());

        // Check that the fish are randomly placed on the board
        boolean hasFish = false;
        for (int row = 0; row < ModelGameBoard.DIMENSION; row++) {
            for (int col = 0; col < ModelGameBoard.DIMENSION; col++) {
                if (model.fishAt(row, col)) {
                    hasFish = true;
                    break;
                }
            }
            if (hasFish) {
                break;
            }
        }
        assertTrue(hasFish);
    }

    @Test
    void testMakeGuess() {
        ControllerGameBoard controller = new ControllerGameBoard();
        ModelGameBoard model = controller.modelGameBoard;

        // Make a guess that hits a fish
        int fishRow = 0;
        int fishCol = 0;
        while (!model.fishAt(fishRow, fishCol)) {
            fishRow++;
            fishCol++;
        }
        controller.makeGuess(fishRow, fishCol);
        assertEquals(2, model.getFishRemaining());
        assertEquals(9, model.getGuessesRemaining());
        assertTrue(model.isTileRevealed(fishRow, fishCol));
        assertFalse(controller.isGameOver());

        // Make a guess that misses a fish
        int emptyRow = 0;
        int emptyCol = 0;
        while (model.fishAt(emptyRow, emptyCol) || model.isTileRevealed(emptyRow, emptyCol)) {
            emptyRow++;
            emptyCol++;
        }
        controller.makeGuess(emptyRow, emptyCol);
        assertEquals(2, model.getFishRemaining());
        assertEquals(8, model.getGuessesRemaining());
        assertTrue(model.isTileRevealed(emptyRow, emptyCol));
        assertFalse(controller.isGameOver());

        // Make guesses until the game is over
        for (int row = 0; row < ModelGameBoard.DIMENSION; row++) {
            for (int col = 0; col < ModelGameBoard.DIMENSION; col++) {
                if (!model.fishAt(row, col) && !model.isTileRevealed(row, col)) {
                    controller.makeGuess(row, col);
                }
            }
        }
        assertTrue(controller.isGameOver());
        if (model.getFishRemaining() == 0) {
            assertTrue(controller.fishWin());
            assertFalse(controller.playerWins());
        } else {
            assertFalse(controller.fishWin());
            assertTrue(controller.playerWins());
        }
    }
}
