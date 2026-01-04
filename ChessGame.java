
/**
 * Write a description of class ChessGame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class ChessGame extends BoardGame
{
    public static final boolean WHITE = true;
    public static final boolean BLACK = false;
    private boolean turn;
    private HashMap <Boolean,ArrayList<ChessPiece>> taken;
    private ArrayList<ChessPiece> takenWhite,takenBlack;
    public ChessGame()
    {    
        super();
        turn = true;
        current = board[0][0];
        taken = new HashMap();
        takenWhite = new ArrayList<>();
        takenBlack = new ArrayList<>();
        //white pieces
        super.addPiece(new Rook(new Position(0,0),this,WHITE));
        super.addPiece(new Knight(new Position(0,1),this,WHITE));
        super.addPiece(new Bishop(new Position(0,2),this,WHITE));
        super.addPiece(new Queen(new Position(0,3),this,WHITE));
        //super.addPiece(new King(new Position(0,4),this,WHITE));
        super.addPiece(new Bishop(new Position(0,5),this,WHITE));
        super.addPiece(new Knight(new Position(0,6),this,WHITE));
        super.addPiece(new Rook(new Position(0,7),this,WHITE));

        //black
        super.addPiece(new Rook(new Position(7,0),this,BLACK));
        super.addPiece(new Knight(new Position(7,1),this,BLACK));
        super.addPiece(new Bishop(new Position(7,2),this,BLACK));
        super.addPiece(new Queen(new Position(7,3),this,BLACK));
        //super.addPiece(new King(new Position(7,4),this,BLACK));
        super.addPiece(new Bishop(new Position(7,5),this,BLACK));
        super.addPiece(new Knight(new Position(7,6),this,BLACK));
        super.addPiece(new Rook(new Position(7,7),this,BLACK));
    }

    public boolean movePiece(Position move) {
        if (move.getRow() < 0 || move.getCol() < 0 || move.getRow() >= dim || move.getCol() >= dim) {
            return false;
        }

        ChessPiece destinationPiece = board[move.getRow()][move.getCol()];

        //  Don't allow capturing your own piece
        if (destinationPiece != null && destinationPiece.getColour() == current.getColour()) {
            return false;
        }

        //  Allow legal moves
        if (current != null && current.canMoveTo(move)) {
            // Capture opponent's piece
            if (destinationPiece != null && destinationPiece.getColour() != current.getColour()) {
                if(destinationPiece.getColour()){
                    takenWhite.add(board[move.getRow()][move.getCol()]);  
                }
                else{
                    takenBlack.add(board[move.getRow()][move.getCol()]);  
                }
                if (destinationPiece.getColour()){
                taken.put(board[move.getRow()][move.getCol()].getColour(),takenWhite);
                }
                else {
                    taken.put(board[move.getRow()][move.getCol()].getColour(),takenBlack);
                }
                board[move.getRow()][move.getCol()] = null; // Remove it from the board

            }

            // Move the piece
            board[move.getRow()][move.getCol()] = current;
            board[current.getPosition().getRow()][current.getPosition().getCol()] = null;
            current.pos = move; // Update internal position
            return true;
        }

        return false;
    }

    public void run(){
        boolean run = true;
        Scanner user = new Scanner(System.in);;
        System.out.println("White moves first.");
        printBoard();
        while (run){
            if (turn){//white move
                System.out.println("White's turn");
                System.out.println("Please type the current postion of the piece or type 'q' to quit");
                String userInput = user.nextLine().trim().toLowerCase();
                if(userInput.toLowerCase().equals("q")) {
                    user.close();
                    run = false;
                    break;
                }
                Position inputMove = new Position(userInput.toLowerCase());// save which piece would like to be moved
                current = board[inputMove.getRow()][inputMove.getCol()];
                if (current.getColour() != WHITE){
                    System.out.println("you cannot move your oppenents piece.");
                }
                if (!inputMove.isValid()) {
                    System.out.println("Invalid input. Please try again.");
                    continue;
                }
                if (!isOccupied(inputMove)){
                    System.out.println("you can not move an empty square");
                    continue;
                }
                System.out.println("Please type the postion you would like the piece to move to or type 'q' to quit");
                userInput = user.nextLine().trim().toLowerCase();
                inputMove = new Position(userInput.toLowerCase());// the actual movement of that piece

                if (movePiece(inputMove)) {
                    printBoard();
                    turn = false; 
                }
                else {
                    printBoard();
                    System.out.println("you cannot take your own pieces.");
                    continue;
                }
            }

            if (turn == false){//black move
                System.out.println("Black's turn");
                System.out.println("Please type the current postion of the piece or type 'q' to quit");
                String userInput = user.nextLine().trim().toLowerCase();
                if(userInput.toLowerCase().equals("q")) {
                    user.close();
                    run = false;
                    break;
                }
                Position inputMove = new Position(userInput.toLowerCase());// save which piece would like to be moved
                current = board[inputMove.getRow()][inputMove.getCol()];
                if (current.getColour() != BLACK){
                    System.out.println("you cannot move your oppenents piece.");
                }
                if (!inputMove.isValid()) {
                    System.out.println("Invalid input. Please try again.");
                    continue;
                }
                if (!isOccupied(inputMove)){
                    System.out.println("you can not move an empty square");
                    continue;
                }
                System.out.println("Please type the postion you would like the piece to move to or type 'q' to quit");
                userInput = user.nextLine().trim().toLowerCase();
                inputMove = new Position(userInput.toLowerCase());// the actual movement of that piece

                if (movePiece(inputMove)) {
                    printBoard();
                    turn = true;

                }
                else {
                    printBoard();
                    System.out.println("you cannot take your own pieces.");
                    continue;
                }
            }

        }
        if (run == false){
            System.out.println("User has quit the game.");
        }   
    }
    @Override
    public String toString(){
        return (super.toString() +"\nWhite pieces taken: " + taken.get(WHITE)+"\nBlack pieces taken: " + taken.get(BLACK));
    }
    public static void main(String[] args){
        BoardGame game = new ChessGame();
        game.run();
    }

}
