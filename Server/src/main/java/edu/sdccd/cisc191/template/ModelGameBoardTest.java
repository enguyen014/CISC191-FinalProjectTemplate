package edu.sdccd.cisc191.template;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ModelGameBoardTest{

    private ModelGameBoard gameBoard;

    @Before
    public void setUp() throws Exception {
        gameBoard = new ModelGameBoard();
    }

    @Test
    public void testGetFishRemaining() {
        assertEquals(10, gameBoard.getFishRemaining());
    }

    @Test
    public void testDecrementFishRemaining() {
        gameBoard.decrementFishRemaining();
        assertEquals(10, gameBoard.getFishRemaining());
    }

    @Test
    public void testGetGuessesRemaining() {
        assertEquals(30, gameBoard.getGuessesRemaining());
    }

    @Test
    public void testDecrementGuessesRemaining() {
        gameBoard.decrementGuessesRemaining();
        assertEquals(30, gameBoard.getGuessesRemaining());
    }

    @Test
    public void testFishAt() {
        assertFalse(gameBoard.fishAt(0, 0));
    }

    @Test
    public void testMakeGuess() {
        gameBoard.makeGuess(0, 0);
        assertEquals(29, gameBoard.getGuessesRemaining());
    }

    @Test
    public void testIsGameOver() {
        assertFalse(gameBoard.isGameOver());
    }

}
