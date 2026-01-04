
/**
 * Write a description of class Queen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Queen extends ChessPiece
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Queen
     */
    public Queen(Position pos,BoardGame game){
        super(pos,game,WHITE);
    }
    public Queen(Position pos,BoardGame game, boolean colour)
    {
        super(pos,game,colour);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean canMoveTo(Position other){
        int row = other.getRow();
        int col = other.getCol();
        int rowDiff = Math.abs(getPosition().getRow() - other.getRow());
        int colDiff = Math.abs(getPosition().getCol() - other.getCol());
    
        // same row, column, or diagonal
        return getPosition().getRow() == other.getRow()|| getPosition().getCol() == other.getCol()|| rowDiff == colDiff;
    }
        public List<Position> getThreatenedPositions() {
        List<Position> threatened = new ArrayList<>();
        int r = getPosition().getRow();
        int c = getPosition().getCol();

        for (int i = 0; i <game.getSize() ; i++) {
            if (i != c) threatened.add(new Position(r, i)); // same row
            if (i != r) threatened.add(new Position(i, c)); // same column
        }

        // diagonal index for each queen piece
        for (int i = 1; i < game.getSize(); i++) {
            if (r + i < game.getSize() && c + i < game.getSize()) threatened.add(new Position(r + i, c + i));
            if (r + i < game.getSize() && c - i >= 0) threatened.add(new Position(r + i, c - i));
            if (r - i >= 0 && c + i < game.getSize()) threatened.add(new Position(r - i, c + i));
            if (r - i >= 0 && c - i >= 0) threatened.add(new Position(r - i, c - i));
        }

        return threatened;
    }
    
    public ArrayList<Position> generatePossibleMoves() {
        int[][] queenDirections = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1},
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        return generateSlidingMoves(queenDirections);
    }

    public String toString(){   
        if (pieceColour){
            return "Q";
        }
        return "q";
    }

}
