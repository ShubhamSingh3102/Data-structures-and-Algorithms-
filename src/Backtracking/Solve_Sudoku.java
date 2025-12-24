//package Backtracking;
//import java.util.*;
//public class Solve_Sudoku {
//    public static boolean isValid(char[][] board,int row,int col,char num){
//        // check row
//        for(int j=0;j<9;j++){
//            if(board[row][j] == num){
//                return false;
//            }
//        }
//        // check column
//        for(int i=0;i<9;i++){
//            if(board[i][col] == num){
//                return false;
//            }
//        }
//        // check 3x3 grid
//        int sRow = row/3*3; //// from left to right....
//        int sCol = col/3*3; //// from left to right....
//        for(int i=sRow;i<sRow+3;i++){
//            for(int j=sCol;j<sCol+3;j++){
//                if(board[i][j] == num){
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//    public static void solve(char[][] board,int row,int col,char[][] grid){
//        if(row == 9){
//            // temporary copies....
//            for(int i=0;i<9;i++){
//                for(int j=0;j<9;j++){
//                    grid[i][j] = board[i][j];
//                }
//            }
//            return;
//        }
//        else if(board[row][col] != '.'){ //// call lagao...
//            if(col<8){
//                solve(board,row,col+1,grid);
//            }
//            else{
//                solve(board,row+1,0,grid);
//            }
//        }
//        else{ // board[row][col] == '.'
//           for(char ch = '1';ch <= '9';ch++){
//               if(isValid(board,row,col,ch)){ //// if valid hai to insert kr do...
//                   board[row][col] = ch;
//                   if(col<8){
//                       solve(board,row,col+1,grid);
//                   }
//                   else{
//                       solve(board,row+1,0,grid);
//                   }
//                   //// backtracking....
//                   board[row][col] = '.'; // agar isme se kuch answer nhi aaya toh...
//               }
//           }
//        }
//    }
//    public static void solveSudoku(char[][] board){
//        char[][] grid = new char[9][9];
//        solve(board,0,0,grid);
//        for(int i=0;i<9;i++){
//            for(int j=0;j<9;j++){
//                board[i][j] = grid[i][j];
//            }
//        }
//    }
//    public static void main(String[] args) {
//        char[][] board = {
//                {'5','3','.','.','7','.','.','.','.'},
//                {'6','.','.','1','9','5','.','.','.'},
//                {'.','9','8','.','.','.','.','6','.'},
//                {'8','.','.','.','6','.','.','.','3'},
//                {'4','.','.','8','.','3','.','.','1'},
//                {'7','.','.','.','2','.','.','.','6'},
//                {'.','6','.','.','.','.','2','8','.'},
//                {'.','.','.','4','1','9','.','.','5'},
//                {'.','.','.','.','8','.','.','7','9'}
//        };
//
//        solveSudoku(board);
//
//        // print solved sudoku
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.print(board[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//}


































//// Optimised Code without taking extra space
package Backtracking;
import java.util.*;
public class Solve_Sudoku {
    static int check = 0; //// global variable
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
    public static void solve(char[][] board,int row,int col){
        if(row == 9){ //// iss samay pr pe board is full and prefect....
            check = 1;
        }
        else if(board[row][col] != '.'){ //// call lagao...
            if(col<8){
                solve(board,row,col+1);
            }
            else{
                solve(board,row+1,0);
            }
        }
        else{ // board[row][col] == '.'
            for(char ch = '1';ch <= '9';ch++){
                if(isValid(board,row,col,ch)){ //// if valid hai to insert kr do...
                    board[row][col] = ch;
                    if(col<8){
                        solve(board,row,col+1);
                    }
                    else{
                        solve(board,row+1,0);
                    }
                    if(check == 1){
                        return;
                    }
                    //// backtracking....
                    board[row][col] = '.'; // agar isme se kuch answer nhi aaya toh...
                }
            }
        }
    }
    public static void solveSudoku(char[][] board){
        solve(board,0,0);
        check = 0; //// leetCode problem...hamesha 1 bana diya kro....
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

        solveSudoku(board);

        // print solved sudoku
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
