package edu.sdccd.cisc191.template;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameBoardLabelTest {

    @Test
    public void testSetText() {
        GameBoardLabel label = new GameBoardLabel();
        String expected = "Test Text";
        label.setText(expected);
        String actual = label.getText();
        assertEquals(expected, actual);
    }
}