
/**
 * Write a description of class Rook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
public class Rook extends ChessPiece
{

    /**
     * Constructor for objects of class Rook
     */
    public Rook(Position pos,BoardGame game){
        super(pos,game,WHITE);
    }
    public Rook(Position pos,BoardGame game, boolean colour)
    {
        super(pos,game,colour);
    }
    public boolean canMoveTo(Position other){
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        if (row < 0 || col < 0 || row >= game.getSize() || col >= game.getSize()) {
        return false;
        }
        return getPosition().getRow() == other.getRow() || getPosition().getCol() == other.getCol();
    }

    public ArrayList<Position> generatePossibleMoves() {
        int[][] rookDirections = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}
        };
        return generateSlidingMoves(rookDirections);
    }

        public String toString(){
        if (pieceColour){
            return "R";
        }
        return "r";
    }
}
