package Backtracking;
import java.util.*;
public class Valid_Sudoku {

    public static boolean isValid(char[][] board,int row,int col,char num){
        // check row
        for(int j=0;j<9;j++){
            if(board[row][j] == num){
                return false;
            }
        }
        // check column
        for(int i=0;i<9;i++){
            if(board[i][col] == num){
                return false;
            }
        }
        // check 3x3 grid
        int sRow = row/3*3; //// from left to right....
        int sCol = col/3*3; //// from left to right....
        for(int i=sRow;i<sRow+3;i++){
            for(int j=sCol;j<sCol+3;j++){
                if(board[i][j] == num){
                    return false;
                }
            }
        }
        return true;
    }
    //// 9 * 9 matrix board....
    public static boolean isValidSudoku(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){ //// phele se khali hai to check hi nhi karna hamko..
                    continue;
                }
                char num = board[i][j]; //// particular element ko bahar nikal do....aur usko dot se mark kr do....
                board[i][j] = '.';
                if(isValid(board,i,j,num) == false){
                    return false;
                }
                //// if true....
                board[i][j] = num;

            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
