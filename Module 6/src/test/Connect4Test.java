package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Connect4;

public class Connect4Test {
    private Connect4 connect4;

    // check Player X
    char[][] gridDiagonalDownX = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'X', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', 'X', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', 'X', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'X'}

    };

    char[][] gridDiagonalUpX = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'X', ' ', ' ', ' '},
            {' ', ' ', 'X', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
            {'X', ' ', ' ', ' ', ' ', ' ', ' '}

    };

    char[][] gridVeritcalX = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '},
            {' ', 'X', ' ', ' ', ' ', ' ', ' '}

    };

    char[][] gridHorizontalX = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'X', 'X', 'X', 'X'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '}

    };

    // check Player O
    char[][] gridDiagonalDownO = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'O', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', 'O', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', 'O', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'O'}

    };

    char[][] gridDiagonalUpO = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', 'O', ' ', ' ', ' '},
            {' ', ' ', 'O', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {'O', ' ', ' ', ' ', ' ', ' ', ' '}

    };

    char[][] gridVeritcalO = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '},
            {' ', 'O', ' ', ' ', ' ', ' ', ' '}

    };

    char[][] gridHorizontalO = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {'O', 'O', 'O', 'O', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '}

    };

    char[][] gridTie = {
            {'X', 'X', 'O', 'O', 'X', 'X', 'X'},
            {'O', 'O', 'X', 'X', 'O', 'O', 'O'},
            {'X', 'X', 'O', 'O', 'X', 'X', 'X'},
            {'O', 'O', 'X', 'X', 'O', 'O', 'O'},
            {'X', 'X', 'O', 'X', 'X', 'O', 'X'},
            {'O', 'O', 'X', 'X', 'O', 'O', 'X'}

    };

    char[][] gridBlank = new char[6][7];

    @Before
    public void setUp() throws Exception {
        connect4 = new Connect4();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testChooseNextPlayer() {
        assertEquals('X', connect4.chooseNextPlayer('O'));
        assertEquals('O', connect4.chooseNextPlayer('X'));
    }

    @Test
    public void testCheckDiagonalDown() {
        assertTrue(connect4.checkDiagonalDown(gridDiagonalDownX, 'X'));
        assertTrue(connect4.checkDiagonalDown(gridDiagonalDownO, 'O'));
        assertFalse(connect4.checkDiagonalDown(gridDiagonalDownX, 'O'));
        assertFalse(connect4.checkDiagonalDown(gridDiagonalDownO, 'X'));
        assertFalse(connect4.checkDiagonalDown(gridBlank, 'X'));
        assertFalse(connect4.checkDiagonalDown(gridBlank, 'O'));
    }

    @Test
    public void testCheckDiagonalUp() {
        assertTrue(connect4.checkDiagonalUp(gridDiagonalUpX, 'X'));
        assertTrue(connect4.checkDiagonalUp(gridDiagonalUpO, 'O'));
        assertFalse(connect4.checkDiagonalUp(gridDiagonalUpX, 'O'));
        assertFalse(connect4.checkDiagonalUp(gridDiagonalUpO, 'X'));
        assertFalse(connect4.checkDiagonalUp(gridBlank, 'X'));
        assertFalse(connect4.checkDiagonalUp(gridBlank, 'O'));
    }

    @Test
    public void testCheckVertical() {
        assertTrue(connect4.checkVertical(gridVeritcalX, 'X'));
        assertTrue(connect4.checkVertical(gridVeritcalO, 'O'));
        assertFalse(connect4.checkVertical(gridVeritcalX, 'O'));
        assertFalse(connect4.checkVertical(gridVeritcalO, 'X'));
        assertFalse(connect4.checkVertical(gridBlank, 'X'));
        assertFalse(connect4.checkVertical(gridBlank, 'O'));
    }

    @Test
    public void testCheckHorizontal() {
        assertTrue(connect4.checkHorizontal(gridHorizontalX, 'X'));
        assertTrue(connect4.checkHorizontal(gridHorizontalO, 'O'));
        assertFalse(connect4.checkHorizontal(gridHorizontalX, 'O'));
        assertFalse(connect4.checkHorizontal(gridHorizontalO, 'X'));
        assertFalse(connect4.checkHorizontal(gridBlank, 'X'));
        assertFalse(connect4.checkHorizontal(gridBlank, 'O'));
    }

//    @Test
//    public void testDropChip(){
//        char [][] testGrid = new char[0][1];
//        connect4.dropChip(testGrid, 1, 'X' );
//        assertEquals('X', connect4.dropChip(testGrid, 1, 'X'));
//    }


    @Test
    public void testCheckTie() {
        assertTrue(connect4.checkTie(gridBlank, 'X'));
        assertTrue(connect4.checkTie(gridBlank, 'O'));
    }

    @Test
    public void testCheckWinner() {
        assertEquals(true, connect4.checkWinner(gridTie, 'X'));
        assertEquals(true, connect4.checkWinner(gridTie, 'O'));
        assertEquals(false, connect4.checkWinner(gridHorizontalX, 'X'));
        assertEquals(false,connect4.checkWinner(gridVeritcalX, 'X'));
        assertEquals(false,connect4.checkWinner(gridDiagonalUpX, 'X'));
        assertEquals(true,connect4.checkWinner(gridDiagonalDownX, 'O'));
        assertEquals(false,connect4.checkWinner(gridHorizontalO, 'O'));
        assertEquals(false,connect4.checkWinner(gridVeritcalO, 'O'));
        assertEquals(false,connect4.checkWinner(gridDiagonalUpO, 'O'));
        assertEquals(false,connect4.checkWinner(gridDiagonalDownO, 'O'));

    }

    @Test
    public void testValidatePersonMove(){
        char[][] gridTest = new char[6][7];
        assertEquals(false, connect4.validatePersonMove(gridTest, 'a'));
//        assertEquals(true, connect4.validatePersonMove(gridTest, 3));
    }

//    @Test
//    public void testInitializeArray(){
//        assertNotNull("true", connect4.initializeArray(gridBlank));
//    }
}
