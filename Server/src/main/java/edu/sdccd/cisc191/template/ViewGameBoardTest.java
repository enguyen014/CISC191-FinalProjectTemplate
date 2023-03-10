import edu.sdccd.cisc191.template.ViewGameBoard;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ViewGameBoardTest {

    private ViewGameBoard viewGameBoard;

    @Override
    public void start(Stage stage) throws Exception {
        viewGameBoard = new ViewGameBoard();
        viewGameBoard.start(stage);
    }

    @Test
    public void testHeaderLabelsExist() {
        Label fishRemaining = lookup("#fishRemaining").query();
        Label guessesRemaining = lookup("#guessesRemaining").query();
        Label message = lookup("#message").query();

        assertNotNull(fishRemaining);
        assertNotNull(guessesRemaining);
        assertNotNull(message);
    }

    @Test
    public void testHeaderLabelValues() {
        ControllerGameBoard controller = viewGameBoard.controller;

        Label fishRemaining = lookup("#fishRemaining").query();
        Label guessesRemaining = lookup("#guessesRemaining").query();
        Label message = lookup("#message").query();

        assertEquals("Fish: " + controller.modelGameBoard.getFishRemaining(), fishRemaining.getText());
        assertEquals("Bait: " + controller.modelGameBoard.getGuessesRemaining(), guessesRemaining.getText());
        if(controller.fishWin()) {
            assertEquals("Fishes win!", message.getText());
        } else if(controller.playerWins()) {
            assertEquals("You win!", message.getText());
        } else {
            assertEquals("Find the fish!", message.getText());
        }
    }

    // Add more tests as needed
}