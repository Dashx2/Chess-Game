
/**
 * Write a description of class QueensGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class QueensGame extends BoardGame
{
    // instance variables - replace the example below with your own
    
    public static final int NUM_QUEENS = 8;
    private int queensLeft,numQueens;
    

    /**
     * Constructor for objects of class QueensGame
     */
     public QueensGame(){
        this(DIM,NUM_QUEENS);//setting the default board size to the final int
    }
    public QueensGame(int dim,int queens)
    {
        // for the board display use brackets with a space inbetween ([ ]) and then remove the empty space to then place the knight character ([N]), 
        // if too complicated to implement use the example board of row and columns of periods(.)
        super(dim);
        this.queensLeft = queens;
        
    }
    

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int getSize(){
        return dim;
    }
     public boolean isThreatened(Position pos) {
        for (int r = 0; r < dim; r++) {
            for (int c = 0; c < dim; c++) {
                ChessPiece q = board[r][c];
                if (q != null && q.canMoveTo(pos)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean addPiece(ChessPiece piece){
         if (piece.getPosition().getRow()< 0 || piece.getPosition().getCol() < 0 || piece.getPosition().getRow() >= dim || piece.getPosition().getCol() >= dim) {
            return false;
        }
        if (isOccupied(piece.getPosition())) {
            return false;
        }
        board[piece.getPosition().getRow()][piece.getPosition().getCol()] = piece;
        this.current = piece;
        queensLeft--;
        return true;
    }
    public boolean removeQueen(ChessPiece piece){
        if (isOccupied(piece.getPosition())) {
            board[piece.getPosition().getRow()][piece.getPosition().getCol()] = null;
            queensLeft++;
            return true;
        }else return false;
    }
    public boolean allQueensNonThreatening() {
        List<ChessPiece> queens = new ArrayList<>();
        for (int r = 0; r < dim; r++) {
            for (int c = 0; c < dim; c++) {
                if (board[r][c] != null) {
                    queens.add(board[r][c]);
                }
            }
        }
        for (int i = 0; i < queens.size(); i++) {
            for (int j = i + 1; j < queens.size(); j++) {
                if (queens.get(i).canMoveTo(queens.get(j).getPosition())) {
                    return false;
                }
            }
        }
        return true;
    }
        public String toString(){
        String boardString = " ";
        char tempChar = 'a';
        for (int label = 0; label < dim; label++) {
            boardString += " " + tempChar + " ";
            tempChar++;
        }
        boardString += "\n";
        int temp = dim;
        for (int i = this.dim - 1; i >= 0; i--) {
            boardString += temp;
            temp--;
        for (int j = 0; j < dim; j++) {
            ChessPiece piece = board[i][j];
            if (piece != null) {
                boardString += "[" + piece.toString() + "]";
            } else if (isThreatened(new Position(i, j))) {
                boardString += "[x]";
            } else {
                boardString += "[ ]";
            }
        }
        boardString += "\n";
        }
        return boardString;
    }
    public void run(){
        boolean run = true;
        Scanner user = new Scanner(System.in);
        printBoard();
        while (run){
            System.out.println("Please state if you want to add or remove a piece. Or type 'q' to quit");
            String userInput = user.nextLine().trim().toLowerCase();
            if(userInput.toLowerCase().equals("q")) {
                user.close();
                run = false;
                break;
            }
            
            
            if (userInput.toLowerCase().trim().equals("add")){
                System.out.println("Please enter positon to add ");
                userInput = user.nextLine().trim().toLowerCase();
                Position inputMove = new Position(userInput);
                ChessPiece piece = new Queen(inputMove,this);
                if(addPiece(piece)){
                System.out.println("Piece added");
                System.out.println("Remaining Queens: " + queensLeft);
                }else{
                    System.out.println("There is already a Queen placed at "+ piece.getPosition().toString());
                    System.out.println("Remaining Queens: " + queensLeft);
                }
                if (current ==null){
                    System.out.println("Last Placed Queen: None");
                }else System.out.println("Last Placed Queen: "+ current.getPosition().toString());
                printBoard();
                
            }else if(userInput.toLowerCase().trim().equals("remove")){
                System.out.println("Please enter postion to remove");
                userInput = user.nextLine().trim().toLowerCase();
                Position inputMove = new Position(userInput);
                ChessPiece piece = new Queen(inputMove,this);
                if (removeQueen(piece)){
                System.out.println("Piece removed");
                System.out.println("Remaining Queens: " + queensLeft);
                }else{
                    System.out.println("There is no piece at "+piece.getPosition().toString());
                System.out.println("Remaining Queens: " + queensLeft);
                }
                if (current ==null){
                    System.out.println("Last Placed Queen: None");
                }else System.out.println("Last Placed Queen: "+ current.getPosition().toString());
                printBoard();
            }
            
             if (allQueensNonThreatening() && queensLeft == 0) {
            System.out.println("Congratulations! All queens placed with no threats.");
            } else if(allQueensNonThreatening() == false && queensLeft == 0){
            System.out.println("All queens placed, but some threaten each other. Try again.");
            }
            
            }
            
        if (run == false){
        System.out.println("User has quit the game.");
        }
    }
    
    public static void main(String args[]){
        BoardGame game = new QueensGame();
        game.run();
        
    }
}
