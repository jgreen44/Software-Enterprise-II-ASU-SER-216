package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import core.Connect4ComputerPlayer;

public class Connect4ComputerPlayerTest {
    private Connect4ComputerPlayer computerPlayer;

    char [][] halfGrid = new char [3][7];
    char [][] fullGrid = new char [6][7];
    char [][] bloatedGrid = new char[10][7];



    @Before
    public void setUp() throws Exception {
        computerPlayer = new Connect4ComputerPlayer();
    }

    @After
    public void tearDown() throws Exception {
        computerPlayer = null;
    }



    @Test
    public void testChooseNextPlayer(){
        assertEquals('O', computerPlayer.chooseNextPlayer('X'));
        assertEquals('X', computerPlayer.chooseNextPlayer('O'));
    }

}
