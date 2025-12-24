package Backtracking;
import java.util.*;
public class Max_Knights_in_NxN_Board {
    static int maxKnights = -1; //// global variable....
//    static int number = 5;
    public static boolean isSafe(char[][] board,int row,int col){
        int n = board.length;
        int i,j;
        // 2 Up 1 right
        i = row - 2;
        j = col + 1;
        if(i>=0 && j<n && board[i][j] == 'K'){
            return false;
        }
        // 2 Up 1 left
        i = row - 2;
        j = col - 1;
        if(i>=0 && j>=0 && board[i][j] == 'K'){
            return false;
        }


        // 2 Down 1 right
        i = row + 2;
        j = col + 1;
        if(i<n && j<n && board[i][j] == 'K'){
            return false;
        }
        // 2 Down 1 left
        i = row + 2;
        j = col - 1;
        if(i<n && j>=0 && board[i][j] == 'K'){
            return false;
        }


        // 2 Right 1 up
        i = row - 1;
        j = col + 2;
        if(i>=0 && j<n && board[i][j] == 'K'){
            return false;
        }
        // 2 Right 1 Down
        i = row + 1;
        j = col + 2;
        if(i<n && j<n && board[i][j] == 'K'){
            return false;
        }


        // 2 Left 1 up
        i = row - 1;
        j = col - 2;
        if(i>=0 && j>=0 && board[i][j] == 'K'){
            return false;
        }
        // 2 Left 1 Down
        i = row + 1;
        j = col - 2;
        if(i<n && j>=0 && board[i][j] == 'K'){
            return false;
        }
        return true;
    }

    public static void nKnight(char[][] board,int row,int col,int numOfKnights){
        int n = board.length;
        //// base case....
        if (row == n) {
            // print the board
//            if(numOfKnights == number){
//                for (int i = 0; i < n; i++) {
//                    for (int j = 0; j < n; j++) {
//                        System.out.print(board[i][j]);
//                    }
//                    System.out.println();
//                }
//                System.out.println();
//            }
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(board[i][j]);
//                }
//                System.out.println();
//            }
//            System.out.println();
            maxKnights = Math.max(maxKnights,numOfKnights);
            return;
        }

        else if(isSafe(board,row,col)){
            board[row][col] = 'K'; //// agar safe hai to aapne knight ko uss row and column me bhar skta hu....
            if(col < n-1){
                nKnight(board,row,col+1,numOfKnights+1);
            }
            else{
                nKnight(board,row+1,0,numOfKnights+1);
            }
            board[row][col] = '.'; // backtracking.....
        }
        if(col < n-1){
            nKnight(board,row,col+1,numOfKnights);
        }
        else{
            nKnight(board,row+1,0,numOfKnights);
        }
    }
    public static void main(String[] args) {
        int n = 3;
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        nKnight(board,0,0,0);
        System.out.println(maxKnights);
    }
}
