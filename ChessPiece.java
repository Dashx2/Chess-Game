
/**
 * Write a description of class ChessPiece here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public abstract class ChessPiece
{
    // instance variables - replace the example below with your own
    public static final boolean WHITE = true;
    public static final boolean BLACK = false;
    protected Position pos;
    protected boolean pieceColour;
    protected BoardGame game;

    /**
     * Constructor for objects of class ChessPiece
     */
    public ChessPiece(Position pos, BoardGame game,boolean colour)
    {
        this.pos = pos;
        this.game = game;
        this.pieceColour = colour;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Position getPosition(){
        return this.pos;
    }

    public boolean getColour(){
        return this.pieceColour;
    }

    public abstract boolean canMoveTo(Position other);

    public abstract ArrayList<Position> generatePossibleMoves();

    public ArrayList<Position> generateSlidingMoves(int[][] directions) {
        ArrayList<Position> possibleMoves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();

        for (int[] dir : directions) {
            int dr = dir[0];
            int dc = dir[1];
            int newRow = row + dr;
            int newCol = col + dc;

            while (newRow >= 0 && newCol >= 0 && newRow < game.getSize() && newCol < game.getSize()) {
                Position newPos = new Position(newRow, newCol);

                if (game.isOccupied(newPos)) break; // stop at first occupied square

                possibleMoves.add(newPos);
                newRow += dr;
                newCol += dc;
            }
        }

        return possibleMoves;
    }

    public boolean equals(Object obj){
        if  (obj == null){
            return false;
        }
        if (obj == this){
            return true;
        }
        if(!(obj.getClass().equals(this.getClass()))){
            return false;
        }
        ChessPiece piece2 = (ChessPiece) obj;

        return this.equals(piece2.pos) && game == piece2.game && pieceColour == piece2.pieceColour; 
    }
}
