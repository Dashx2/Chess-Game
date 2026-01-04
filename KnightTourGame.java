
/**
 * Write a description of class KnightTourGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class KnightTourGame extends BoardGame
{
    // permament int for chess board dimension
    private int squaresLeft;
    
    
    /**
     * Constructor for objects of class KnightTourGame
     */
    public KnightTourGame(){
        this(DIM);//setting the default board size to the final int
    }
    public KnightTourGame(int dim)
    {
        // for the board display use brackets with a space inbetween ([ ]) and then remove the empty space to then place the knight character ([N]), 
        // if too complicated to implement use the example board of row and columns of periods(.)
        super(dim);
        this.squaresLeft = (dim*dim);
        
        
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
    
    public boolean addPiece(ChessPiece piece){
        if (piece.getPosition().getRow()< 0 || piece.getPosition().getCol() < 0 || piece.getPosition().getRow() >= dim || piece.getPosition().getCol() >= dim) {
            return false;
        }
        if (isOccupied(piece.getPosition())) {
            return false;
        }
        if (current == null){
            board[piece.getPosition().getRow()][piece.getPosition().getCol()] =  piece; 
            //using a public boolean for a single use to place down the first Knight piece
            this.current = piece;
            squaresLeft--;
            return true;
        }
        if(current.canMoveTo(piece.getPosition())){
            // the actual addPiece Method
            board[piece.getPosition().getRow()][piece.getPosition().getCol()] =  piece;
            this.current = piece;
            squaresLeft--;
            return true;
        }
        else return false;
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
                     board += "["+ current.toString()+"]";
                }
                else 
                board += "[ ]";
                
            }
            board += "\n";
        }
        return board;
    }
    public ArrayList<Position> generatePossibleMoves(){
        if (current == null) return new ArrayList<>();
        ArrayList<Position> possibleMoves = current.generatePossibleMoves();//call to see all possible legal moves for the knight without checking for legalilty or occupation
        ArrayList<Position> legalMoves = new ArrayList<>();
        for (Position temp:possibleMoves){
            if (temp != null && temp.isValid() && current.canMoveTo(temp)) {
            legalMoves.add(temp);
            }
        }
        return legalMoves;
    }
    
    public void run(){
        boolean run = true;
        Scanner user = new Scanner(System.in);
        printBoard();
        System.out.println("Please state the placement position of the first Knight piece using standard chess notation or typing 'q' to quit");
        
        while (run){
            String userInput = user.nextLine().trim().toLowerCase();
            if(userInput.toLowerCase().equals("q")) {
                user.close();
                run = false;
                break;
            }
            Position inputMove = new Position(userInput.toLowerCase());
            if (!inputMove.isValid()) {
            System.out.println("Invalid input. Please try again.");
            continue;
            }
            ChessPiece piece = new Knight(inputMove, this);
            if (addPiece(piece)){
                System.out.println("Sucessful move");
                System.out.println("Remaining squares: " + squaresLeft);
                System.out.println("Current position: " + current.getPosition().toString());
            }
            else{
                System.out.println("Move " +userInput + " not possible" );
                System.out.println("Current position: " + current.getPosition().toString());
                
            }
            int legalMovesCount = generatePossibleMoves().size();
            if(generatePossibleMoves().size() == 0){
                user.close();
                System.out.println("User has run out of legal moves. \nGame Over!");
                printBoard();

                break;
            }
            printBoard();
            
        }
        if (run == false){
        System.out.println("User has quit the game.");
        }   
    }
    
    public static void main(String[]args){
        BoardGame game = new KnightTourGame();
        game.run();
    }
}
