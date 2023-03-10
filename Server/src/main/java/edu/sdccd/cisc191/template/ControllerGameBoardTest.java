package edu.sdccd.cisc191.template;

import edu.sdccd.cisc191.template.ControllerGameBoard;
import edu.sdccd.cisc191.template.ModelGameBoard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ControllerGameBoardTest {

    @Test
    void testInitializeGameBoard() {
        ControllerGameBoard controller = new ControllerGameBoard();
        ModelGameBoard model = controller.modelGameBoard;

        // Check that the game board is initialized with the correct number of fish and guesses
        assertEquals(10, model.getFishRemaining());
        assertEquals(30, model.getGuessesRemaining());

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
        assertEquals(9, model.getFishRemaining());
        assertEquals(29, model.getGuessesRemaining());

        // Make a guess that misses a fish
        int emptyRow = 0;
        int emptyCol = 0;
        while (model.fishAt(emptyRow, emptyCol) || model.isTileRevealed(emptyRow, emptyCol)) {
            emptyRow++;
            emptyCol++;
        }
        controller.makeGuess(emptyRow, emptyCol);
        assertEquals(9, model.getFishRemaining());
        assertEquals(28, model.getGuessesRemaining());

        // Make guesses until the game is over
        for (int row = 0; row < ModelGameBoard.DIMENSION; row++) {
            for (int col = 0; col < ModelGameBoard.DIMENSION; col++) {
                if (!model.fishAt(row, col) && !model.isTileRevealed(row, col)) {
                    controller.makeGuess(row, col);
                }
            }
        }
    }
}
