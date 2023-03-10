package edu.sdccd.cisc191.template;

import static org.junit.Assert.*;

import org.junit.Before;
import org.testng.annotations.Test;

public class ModelGameBoardTest{

    private ModelGameBoard gameBoard;

    @Before
    public void setUp() throws Exception {
        gameBoard = new ModelGameBoard();
    }

    @Test
    public void testGetFishRemaining() {
        assertEquals(3, gameBoard.getFishRemaining());
    }

    @Test
    public void testDecrementFishRemaining() {
        gameBoard.decrementFishRemaining();
        assertEquals(2, gameBoard.getFishRemaining());
    }

    @Test
    public void testGetGuessesRemaining() {
        assertEquals(10, gameBoard.getGuessesRemaining());
    }

    @Test
    public void testDecrementGuessesRemaining() {
        gameBoard.decrementGuessesRemaining();
        assertEquals(9, gameBoard.getGuessesRemaining());
    }

    @Test
    public void testFishAt() {
        assertFalse(gameBoard.fishAt(0, 0));
    }

    @Test
    public void testMakeGuess() {
        gameBoard.makeGuess(0, 0);
        assertEquals(9, gameBoard.getGuessesRemaining());
    }

    @Test
    public void testIsGameOver() {
        assertFalse(gameBoard.isGameOver());
    }

}
