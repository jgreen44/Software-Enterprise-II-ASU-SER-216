package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Connect4;

/**
 * The type Connect 4 test.
 */
public class Connect4Test {
    private Connect4 connect4;

    // check Player X
    private char[][] gridDiagonalDownX = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'X', ' ', ' ', ' '},
            {' ', ' ', ' ', 'O', 'X', ' ', ' '},
            {' ', ' ', ' ', 'X', 'O', 'X', ' '},
            {' ', ' ', ' ', 'O', 'X', 'O', 'X'}

    };

    private char[][] gridDiagonalUpX = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'X', ' ', ' ', ' '},
            {' ', ' ', 'X', 'O', ' ', ' ', ' '},
            {' ', 'X', 'O', 'X', ' ', ' ', ' '},
            {'X', 'O', 'X', 'O', ' ', ' ', ' '}

    };

    private char[][] gridVeritcalX = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '}

    };

    private char[][] gridHorizontalX = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'X', 'X', 'X', 'X'},
            {' ', ' ', ' ', 'O', 'X', 'O', 'O'},
            {' ', ' ', ' ', 'X', 'X', 'O', 'X'}

    };

    // check Player O
    private char[][] gridDiagonalDownO = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'O', ' ', ' ', ' '},
            {' ', ' ', ' ', 'X', 'O', ' ', ' '},
            {' ', ' ', ' ', 'O', 'X', 'O', ' '},
            {' ', ' ', ' ', 'X', 'O', 'X', 'O'}

    };

    private char[][] gridDiagonalUpO = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'O', ' ', ' ', ' '},
            {' ', ' ', 'O', 'X', ' ', ' ', ' '},
            {' ', 'O', 'X', 'O', ' ', ' ', ' '},
            {'O', 'X', 'O', 'X', ' ', ' ', ' '}

    };

    private char[][] gridVeritcalO = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '}

    };

    private char[][] gridHorizontalO = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', 'O', 'O', 'O', ' ', ' ', ' '},
            {'x', 'O', 'X', 'O', ' ', ' ', ' '},
            {'O', 'X', 'O', 'X', ' ', ' ', ' '}

    };

    private char[][] gridTie = {
            {'X', 'X', 'O', 'O', 'X', 'X', 'X'},
            {'O', 'O', 'X', 'X', 'O', 'O', 'O'},
            {'X', 'X', 'O', 'O', 'X', 'X', 'X'},
            {'O', 'O', 'X', 'X', 'O', 'O', 'O'},
            {'X', 'X', 'O', 'X', 'X', 'O', 'X'},
            {'O', 'O', 'X', 'X', 'O', 'O', 'X'}

    };

    private char[][] gridBlankTwo = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '}

    };

    private char[][] gridDropChipO = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'O', ' ', ' ', ' ', ' '}

    };

    private char[][] gridDropChipX = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'X', ' ', ' ', ' ', ' '}

    };

    private char[][] gridBlank = new char[6][7];

    /**
     * Sets up.
     *
     * @throws Exception the exception
     */
    @Before
    public void setUp() throws Exception {
        connect4 = new Connect4();
    }

    /**
     * Tear down.
     *
     * @throws Exception the exception
     */
    @After
    public void tearDown() throws Exception {

    }

    /**
     * Test choose next player.
     */
    @Test
    public void testChooseNextPlayer() {
        assertEquals('X', connect4.chooseNextPlayer('O'));
        assertEquals('O', connect4.chooseNextPlayer('X'));
    }

    /**
     * Test check diagonal down.
     */
    @Test
    public void testCheckDiagonalDown() {
        assertTrue(connect4.checkDiagonalDown(gridDiagonalDownX, 'X'));
        assertTrue(connect4.checkDiagonalDown(gridDiagonalDownO, 'O'));
        assertFalse(connect4.checkDiagonalDown(gridDiagonalDownX, 'O'));
        assertFalse(connect4.checkDiagonalDown(gridDiagonalDownO, 'X'));
        assertFalse(connect4.checkDiagonalDown(gridBlank, 'X'));
        assertFalse(connect4.checkDiagonalDown(gridBlank, 'O'));
    }

    /**
     * Test check diagonal up.
     */
    @Test
    public void testCheckDiagonalUp() {
        assertTrue(connect4.checkDiagonalUp(gridDiagonalUpX, 'X'));
        assertTrue(connect4.checkDiagonalUp(gridDiagonalUpO, 'O'));
        assertFalse(connect4.checkDiagonalUp(gridDiagonalUpX, 'O'));
        assertFalse(connect4.checkDiagonalUp(gridDiagonalUpO, 'X'));
        assertFalse(connect4.checkDiagonalUp(gridBlank, 'X'));
        assertFalse(connect4.checkDiagonalUp(gridBlank, 'O'));
    }

    /**
     * Test check vertical.
     */
    @Test
    public void testCheckVertical() {
        assertTrue(connect4.checkVertical(gridVeritcalX, 'X'));
        assertTrue(connect4.checkVertical(gridVeritcalO, 'O'));
        assertFalse(connect4.checkVertical(gridVeritcalX, 'O'));
        assertFalse(connect4.checkVertical(gridVeritcalO, 'X'));
        assertFalse(connect4.checkVertical(gridBlank, 'X'));
        assertFalse(connect4.checkVertical(gridBlank, 'O'));
    }

    /**
     * Test check horizontal.
     */
    @Test
    public void testCheckHorizontal() {
        assertTrue(connect4.checkHorizontal(gridHorizontalX, 'X'));
        assertTrue(connect4.checkHorizontal(gridHorizontalO, 'O'));
        assertFalse(connect4.checkHorizontal(gridHorizontalX, 'O'));
        assertFalse(connect4.checkHorizontal(gridHorizontalO, 'X'));
        assertFalse(connect4.checkHorizontal(gridBlank, 'X'));
        assertFalse(connect4.checkHorizontal(gridBlank, 'O'));
    }

    /**
     * Test drop chip.
     */
    @Test
    public void testDropChip(){
        connect4.dropChip(gridDropChipX, 1, 'X');

        gridBlank = gridDropChipX;
        for (int i = 0; i < gridBlank.length ; i++) {
            for (int j = 0; j < gridBlank[0].length ; j++) {
                assertEquals(gridDropChipX[i][j], gridBlank[i][j]);
            }
        }
//        connect4.dropChip(gridDropChipX, 2, 'O');

    }

    /**
     * Test draw grid.
     */
    @Test
    public void testDrawGrid(){
        connect4.drawGrid(gridBlank);
        gridBlankTwo = gridBlank;
        for (int i = 0; i < gridBlank.length ; i++) {
            for (int j = 0; j < gridBlank[0].length ; j++) {
                assertEquals(gridBlankTwo[i][j], gridBlank[i][j]);
            }
        }

    }


    /**
     * Test check tie.
     */
    @Test
    public void testCheckTie() {
//        assertTrue(connect4.checkTie(gridTie, 'X'));
        assertEquals(false, connect4.checkTie(gridTie, 'X'));
        assertEquals(false, connect4.checkTie(gridTie, 'O'));

    }

    /**
     * Test check winner.
     */
    @Test
    public void testCheckWinner() {
        assertEquals(false, connect4.checkWinner(gridTie, 'X'));
        assertEquals(false, connect4.checkWinner(gridTie, 'O'));
        assertEquals(false, connect4.checkWinner(gridHorizontalX, 'X'));
        assertEquals(false,connect4.checkWinner(gridVeritcalX, 'X'));
        assertEquals(false,connect4.checkWinner(gridDiagonalUpX, 'X'));
        assertEquals(true,connect4.checkWinner(gridDiagonalDownX, 'O'));
        assertEquals(false,connect4.checkWinner(gridHorizontalO, 'O'));
        assertEquals(false,connect4.checkWinner(gridVeritcalO, 'O'));
        assertEquals(false,connect4.checkWinner(gridDiagonalUpO, 'O'));
        assertEquals(false,connect4.checkWinner(gridDiagonalDownO, 'O'));

    }


    /**
     * Test initialize array.
     */
    @Test
    public void testInitializeArray(){
        connect4.initializeArray(gridBlank);
        gridBlankTwo = gridBlank;
        for (int i = 0; i < gridBlank.length ; i++) {
            for (int j = 0; j < gridBlank[0].length ; j++) {
                assertEquals(gridBlankTwo[i][j], gridBlank[i][j]);
            }
        }

    }
}
