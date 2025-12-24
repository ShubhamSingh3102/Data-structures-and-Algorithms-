package Codeforce_Practice_Question;
import java.util.*;
public class Beautiful_Matrix {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[][] matrix = new int[6][6];
            int row = -1;
            int col = -1;
            for (int i = 1; i <= 5; i++) {
                for (int j = 1; j <= 5; j++) {
                    matrix[i][j] = sc.nextInt();
                    if(matrix[i][j] == 1){
                        row = i;
                        col = j;
                    }
                }
            }
            int moves = Math.abs(row-3)+Math.abs(col-3);
            System.out.println(moves);
        }
    }
}
