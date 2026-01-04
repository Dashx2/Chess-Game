
/**
 * Write a description of class BoardGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class BoardGame
{
    // instance variables - replace the example below with your own
    public static final boolean WHITE = true;
    public static final boolean BLACK = false;
    public static final int DIM =8;
    protected int dim;
    protected ChessPiece[][] board;
    protected ChessPiece current;
    /**
     * Constructor for objects of class BoardGame
     */
    public BoardGame()
    {
        // initialise instance variables
        this(DIM);
    }
    public BoardGame(int dim){
        this.dim = dim;
        board = new ChessPiece[dim][dim];
        current = null;
    }
    public boolean addPiece(ChessPiece piece){
         if (piece.getPosition().getRow()< 0 || piece.getPosition().getCol() < 0 || piece.getPosition().getRow() >= dim || piece.getPosition().getCol() >= dim) {
            return false;
        }
        board[piece.getPosition().getRow()][piece.getPosition().getCol()] = piece;
        return true;
    }
    public boolean canMoveTo(Position other){
        return false;
    }
    public boolean isOccupied(Position pos){
        if(pos.getRow() >= dim || pos.getCol() >= dim || pos.getRow() < 0 || pos.getCol() < 0){
        return false;
        }
        else return (board[pos.getRow()][pos.getCol()] != null); //checks the index for a null index, if true: that means there is an object inside that index,if false:means that at that index is null
    }
    public int getSize(){
        return this.dim;
    }
    public ArrayList<Position> generatePossibleMoves(){
        return new ArrayList<>();
    } 
    public String toString(){
        String board = " ";
        char tempChar = 'a';
        for (int label = 0;label<dim;label++){
            board += " " + tempChar + " ";
            tempChar++;
        }
        board += "\n";
        int temp = dim;
        for (int i = this.dim-1; i>=0;i--){//iterates through the rows top to bottom and the columns from left to right to create the actual chess board
            board += temp;
            temp--;
            for (int j = 0; j<dim; j++){
                
                if(isOccupied(new Position(i,j))){
                     board += "["+ this.board[i][j].toString()+"]";
                }
                else 
                board += "[ ]";
                
            }
            board += "\n";
        }
        return board;
    }
            public void printBoard(){
        //printing the previous toString method
        System.out.println(toString());
    }
    public void run(){
        
    }
        


    
}
