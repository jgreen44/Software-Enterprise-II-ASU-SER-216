package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Connect4;

public class Connect4Test {
    private Connect4 connect4;

    // check Player X
    char [][] gridDiagonalDownX =  {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','X',' ',' ',' '},
            {' ',' ',' ',' ','X',' ',' '},
            {' ',' ',' ',' ',' ','X',' '},
            {' ',' ',' ',' ',' ',' ','X'}

    };

    char [][] gridDiagonalUpX =  {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','X',' ',' ',' '},
            {' ',' ','X',' ',' ',' ',' '},
            {' ','X',' ',' ',' ',' ',' '},
            {'X',' ',' ',' ',' ',' ',' '}

    };

    char [][] gridVeritcalX =  {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ','X',' ',' ',' ',' ',' '},
            {' ','X',' ',' ',' ',' ',' '},
            {' ','X',' ',' ',' ',' ',' '},
            {' ','X',' ',' ',' ',' ',' '}

    };

    char [][] gridHorizontalX =  {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','X','X','X','X'},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '}

    };

    // check Player O
    char [][] gridDiagonalDownO =  {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','O',' ',' ',' '},
            {' ',' ',' ',' ','O',' ',' '},
            {' ',' ',' ',' ',' ','O',' '},
            {' ',' ',' ',' ',' ',' ','O'}

    };

    char [][] gridDiagonalUpO =  {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ','O',' ',' ',' '},
            {' ',' ','O',' ',' ',' ',' '},
            {' ','O',' ',' ',' ',' ',' '},
            {'O',' ',' ',' ',' ',' ',' '}

    };

    char [][] gridVeritcalO =  {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ','O',' ',' ',' ',' ',' '},
            {' ','O',' ',' ',' ',' ',' '},
            {' ','O',' ',' ',' ',' ',' '},
            {' ','O',' ',' ',' ',' ',' '}

    };

    char [][] gridHorizontalO =  {
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {'O','O','O','O',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '},
            {' ',' ',' ',' ',' ',' ',' '}

    };
    char [][] blankGrid = new char [6][7];

    @Before
    public void setUp() throws Exception {
        connect4 = new Connect4();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testChooseNextPlayer(){
        assertEquals('X', connect4.chooseNextPlayer('O'));
        assertEquals('O', connect4.chooseNextPlayer('X'));
    }

    @Test
    public void testCheckDiagonalDown(){
        assertTrue(connect4.checkDiagonalDown(gridDiagonalDownX,  'X'));
        assertTrue(connect4.checkDiagonalDown(gridDiagonalDownO,  'O'));
        assertFalse(connect4.checkDiagonalDown(gridDiagonalDownX, 'O'));
        assertFalse(connect4.checkDiagonalDown(gridDiagonalDownO, 'X'));
        assertFalse(connect4.checkDiagonalDown(blankGrid, 'X'));
        assertFalse(connect4.checkDiagonalDown(blankGrid, 'O'));
    }

    @Test
    public void testCheckDiagonalUp(){
        assertTrue(connect4.checkDiagonalUp(gridDiagonalUpX,  'X'));
        assertTrue(connect4.checkDiagonalUp(gridDiagonalUpO, 'O'));
        assertFalse(connect4.checkDiagonalUp(gridDiagonalUpX, 'O'));
        assertFalse(connect4.checkDiagonalUp(gridDiagonalUpO, 'X'));
        assertFalse(connect4.checkDiagonalUp(blankGrid, 'X'));
        assertFalse(connect4.checkDiagonalUp(blankGrid, 'O'));
    }

    @Test
    public void testCheckVertical(){
        assertTrue(connect4.checkVertical(gridVeritcalX,  'X'));
        assertTrue(connect4.checkVertical(gridVeritcalO, 'O'));
        assertFalse(connect4.checkVertical(gridVeritcalX,  'O'));
        assertFalse(connect4.checkVertical(gridVeritcalO, 'X'));
        assertFalse(connect4.checkVertical(blankGrid, 'X'));
        assertFalse(connect4.checkVertical(blankGrid, 'O'));
    }

    @Test
    public void testCheckHorizontal(){
        assertTrue(connect4.checkHorizontal(gridHorizontalX,  'X'));
        assertTrue(connect4.checkHorizontal(gridHorizontalO, 'O'));
        assertFalse(connect4.checkHorizontal(gridHorizontalX,  'O'));
        assertFalse(connect4.checkHorizontal(gridHorizontalO, 'X'));
        assertFalse(connect4.checkHorizontal(blankGrid, 'X'));
        assertFalse(connect4.checkHorizontal(blankGrid, 'O'));
    }
}
