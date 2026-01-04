
/**
 * Write a description of class Knight here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Knight extends ChessPiece
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class Knight
     */
    public Knight(Position pos,BoardGame game,boolean colour)
    {
        // initialise instance variables
        super(pos,game,colour);
    }
    public Knight(Position pos,BoardGame game){
        this(pos,game,WHITE);
    }
    
    public boolean canMoveTo(Position pos){
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        if (row < 0 || col < 0 || row >= game.getSize() || col >= game.getSize()) {
        return false;
        }
        
        //col is 2 away from this.col and row is 1 away from this.row
        // or col is 1 away this.col and row is 2 away this.row
        int rowDiff = Math.abs(pos.getRow() - row);
        int colDiff = Math.abs(pos.getCol() - col);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }
    public ArrayList<Position> generatePossibleMoves(){
        ArrayList<Position> PossibleMoves = new ArrayList<>();
        int row = getPosition().getRow();
        int col = getPosition().getCol();
        int[][] moves = { {2, 1}, {1, 2}, {-1, 2}, {-2, 1},{-2, -1}, {-1, -2}, {1, -2}, {2, -1} };
        for (int[] move : moves) {
        PossibleMoves.add(new Position(row + move[0], col + move[1]));
        }
        return PossibleMoves;
    }
    public String toString(){
        if (pieceColour){
            return "N";
        }
        return "n";
    }
}
