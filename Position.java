
/**
 * Write a description of class Postition here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
public class Position
{
    // instance variables - replace the example below with your own
    public static final int ERROR_NUM = -1;// if the user inputs an invalid String, the Char array wont auto place a Knight a "a1"
    private int row,col;
    /**
     * Constructor for objects of class Postition
     */
    public Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    // constructor for number row and then letter column
    public Position(char col, int row){
        this.col = charConversionToInt(col);
        this.row = row-1;
        }
    //constructor for move given in String format
    public Position(String s){
        if (s.length() == 2 
        && s.charAt(0) >= 'a' && s.charAt(0) <= 'h' 
        && s.charAt(1) >= '1' && s.charAt(1) <= '8') {
        this.col = charConversionToInt(s.charAt(0));
        this.row = s.charAt(1) - '1';
        } else {
        System.err.println("Invalid position: " + s);
        this.col = ERROR_NUM;
        this.row = ERROR_NUM;
        }
    }
    public boolean isValid() {
    return row >= 0 && col >= 0 && row < 8 && col < 8;
    }

    //convert char to int
     private int charConversionToInt(char col){
        return col - 'a';
    }
    public int getRow(){
        return this.row;
    }
    public int getCol(){
        return this.col;
    }
    
    public String toString(){
        char colChar = (char) ('a' + col);// 'a' = 0, 'b' = 1, etc.
        return "" + colChar + (row + 1);   // row is 0-indexed, so add 1
    }
    public boolean equals(Object obj){
        if  (obj == null){
             return false;
        }
        if (obj == this){
            return true;
        }
        if(!(obj instanceof Position)){
            return false;
        }
        Position pos2 = (Position) obj;
        
        return pos2.row == this.row && this.col == pos2.col;
    }
}
