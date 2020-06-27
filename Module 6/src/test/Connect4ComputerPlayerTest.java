package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Connect4ComputerPlayer;

/**
 * The type Connect 4 computer player test.
 */
public class Connect4ComputerPlayerTest {
    private Connect4ComputerPlayer computerPlayer;


    private char [][] gridBlank = new char [6][7];
    private char[][] gridDropChipO = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', 'O', 'O', 'O', 'O', 'O', 'O'}

    };

    private char[][] gridDropChipX = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'X', 'X', 'X', 'X', 'X', 'X', 'X'}

    };


    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        computerPlayer = new Connect4ComputerPlayer();
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {
        computerPlayer = null;
    }


    /**
     * Test choose next player.
     */
    @Test
    public void testChooseNextPlayer(){
        assertEquals('O', computerPlayer.chooseNextPlayer('X'));
        assertEquals('X', computerPlayer.chooseNextPlayer('O'));
    }

    /**
     * Test computer make move.
     */
    @Test
    public void testComputerMakeMove(){
        computerPlayer.computerMakeMove(gridDropChipX, 'X');

        gridDropChipX = gridBlank;
        for (int i = 0; i < gridBlank.length ; i++) {
            for (int j = 0; j < gridBlank[0].length ; j++) {
                assertEquals(gridDropChipX[i][j], gridBlank[i][j]);
            }
        }
    }

}
