
/**
 * Write a description of class Bishop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Bishop extends ChessPiece
{

    /**
     * Constructor for objects of class Bishop
     */
    public Bishop(Position pos,BoardGame game){
        super(pos,game,WHITE);
    }
    public Bishop(Position pos,BoardGame game, boolean colour)
    {
        super(pos,game,colour);
    }
    public boolean canMoveTo(Position other){
        int row = other.getRow();
        int col = other.getCol();
        int rowDiff = Math.abs(getPosition().getRow() - other.getRow());
        int colDiff = Math.abs(getPosition().getCol() - other.getCol());
        if (row < 0 || col < 0 || row >= game.getSize() || col >= game.getSize()) {
        return false;
        }

        return rowDiff == colDiff;
    }
    
    public ArrayList<Position> generatePossibleMoves() {
        int[][] bishopDirections = {
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
        };
        return generateSlidingMoves(bishopDirections);
    }

        public String toString(){
        if (pieceColour){
            return "B";
        }
        return "b";
    
    }
}
