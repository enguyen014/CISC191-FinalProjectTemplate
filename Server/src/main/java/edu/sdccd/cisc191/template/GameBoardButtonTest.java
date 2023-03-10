import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameBoardButtonTest {

    private GameBoardButton button;

    @Before
    public void setUp() {
        button = new GameBoardButton(0, 0, true);
    }

    @Test
    public void testGetRow() {
        assertEquals(0, button.getRow());
    }

    @Test
    public void testGetColumn() {
        assertEquals(0, button.getColumn());
    }

    @Test
    public void testIsFish() {
        assertTrue(button.isFish());
    }

    @Test
    public void testHandleClick() {
        button.handleClick();
        assertFalse(button.isFish());
    }
}
