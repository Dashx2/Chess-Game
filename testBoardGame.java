

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class testKnightTourGame.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class testBoardGame
{
    /**
     * Default constructor for test class testKnightTourGame
     */
    public testBoardGame()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

 



    @Test
    public void testRook()
    {
        BoardGame boardGam1 = new BoardGame();
        boardGam1.printBoard();
        Position position1 = new Position(0, 0);
        Rook rook1 = new Rook(position1, boardGam1);
        assertEquals(true, boardGam1.addPiece(rook1));
        boardGam1.printBoard();
        Position position2 = new Position("a8");
        Rook rook2 = new Rook(position2, boardGam1);
        assertEquals(true, boardGam1.addPiece(rook2));
        boardGam1.printBoard();
        Position position3 = new Position("h8");
        Rook rook3 = new Rook(position3, boardGam1);
        assertEquals(true, boardGam1.addPiece(rook3));
        boardGam1.printBoard();
        Position position4 = new Position("g7");
        Rook rook4 = new Rook(position4, boardGam1);
        assertEquals(false, boardGam1.addPiece(rook2));
        assertEquals(false, boardGam1.addPiece(rook4));
    }

    @Test
    public void testBishop()
    {
        BoardGame boardGam1 = new BoardGame();
        Position position1 = new Position("a1");
        Bishop bishop1 = new Bishop(position1, boardGam1);
        boardGam1.printBoard();
        assertEquals(true, boardGam1.addPiece(bishop1));
        boardGam1.printBoard();
        Position position2 = new Position("d4");
        Bishop bishop2 = new Bishop(position2, boardGam1);
        assertEquals(true, boardGam1.addPiece(bishop2));
        boardGam1.printBoard();
        Position position3 = new Position("g1");
        Bishop bishop3 = new Bishop(position3, boardGam1);
        assertEquals(true, boardGam1.addPiece(bishop3));
        boardGam1.printBoard();
        Position position4 = new Position ("g2");
        Bishop bishop4 = new Bishop(position4, boardGam1);
        assertEquals(false, boardGam1.addPiece(bishop2));
        assertEquals(false, boardGam1.addPiece(bishop4));
    }

    @Test
    public void testQueen()
    {
        BoardGame boardGam1 = new BoardGame();
        Position position1 = new Position("a1");
        Queen queen1 = new Queen(position1, boardGam1);
        boardGam1.printBoard();
        assertEquals(true, boardGam1.addPiece(queen1));
        boardGam1.printBoard();
        Position position2 = new Position("e5");
        Queen queen2 = new Queen(position2, boardGam1);
        assertEquals(true, boardGam1.addPiece(queen2));
        boardGam1.printBoard();
        Position position3 = new Position("h5");
        Queen queen3 = new Queen(position3, boardGam1);
        assertEquals(true, boardGam1.addPiece(queen3));
        boardGam1.printBoard();
        Position position4 = new Position("h1");
        Queen queen4 = new Queen(position4, boardGam1);
        assertEquals(true, boardGam1.addPiece(queen4));
        boardGam1.printBoard();
        Position position5 = new Position("g3");
        Queen queen5 = new Queen(position5, boardGam1);
        assertEquals(false, boardGam1.addPiece(queen5));
    }

    
}






