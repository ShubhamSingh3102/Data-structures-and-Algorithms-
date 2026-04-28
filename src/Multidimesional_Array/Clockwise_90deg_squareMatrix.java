//package Multidimesional_Array;
//import java.util.Scanner;
//public class Clockwise_90deg_squareMatrix {
//    static void printMatrix(int[][] matrix) {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                System.out.print(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }
//    static void TransposeMatrix(int[][] matrix,int r, int c) {
//        for (int i = 0; i < c; i++) {
//            for (int j = i; j < r; j++) {
//                int temp = matrix[i][j];
//                matrix[i][j] = matrix[j][i];
//                matrix[j][i] = temp;
//            }
//        }
//    }
//    static void reverseMatrix(int[] matrix,int n) {
//        int i = 0,j = n-1;
//        while (i < j) {
//            int temp = matrix[i];
//            matrix[i] = matrix[j];
//            matrix[j] = temp;
//            i++;
//            j--;
//        }
//    }
//    static void clockwiseMatrix(int[][] matrix,int n) {
//        // transpose
//        TransposeMatrix(matrix, n, n);
//
//        for (int i = 0; i < n; i++) {
//            reverseMatrix(matrix[i], n);
//
//
//            // reverse each row of transposed matrix
//            /*
//
//                      1 2 3
//                      4 5 6
//                      7 8 9
//
//                      when i=0;
//                      reverseMatrix({1,2,3})
//                      when i=1;
//                      reverseMatrix({4,5,6})
//                      when i=2;
//                      reverseMatrix({7,8,9})
//
//
//             */
//        }
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter the number of rows: ");
//        int r = sc.nextInt();
//        System.out.println("Enter the number of columns: ");
//        int c = sc.nextInt();
//        int [][] matrix = new int [r][c];
//        System.out.println("Enter the elements of the matrix: ");
//        for(int i = 0; i < matrix.length; i++) {
//            for(int j = 0; j < matrix[i].length; j++) {
//                matrix[i][j] = sc.nextInt();
//                System.out.println(matrix[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println("Input Matrix: ");
//        printMatrix(matrix);
//        clockwiseMatrix(matrix,r);
//        System.out.println("Clockwise Matrix: ");
//        printMatrix(matrix);
//    }
//}





















package Multidimesional_Array;
import java.util.Scanner;
public class Clockwise_90deg_squareMatrix {
    static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    static void TransposeMatrix(int[][] matrix,int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    // row reverse...
    static void reverseMatrix(int[] matrix,int n) {
        int i = 0,j = n-1;
        while (i < j) {
            int temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;
            i++;
            j--;
        }
    }
    static void clockwiseMatrix(int[][] matrix,int n) {
        // transpose
        TransposeMatrix(matrix,n);

        for (int i = 0; i < n; i++) {
            reverseMatrix(matrix[i], n);


            // reverse each row of transposed matrix
            /*

                      1 2 3
                      4 5 6
                      7 8 9

                      when i=0;
                      reverseMatrix({1,2,3})
                      when i=1;
                      reverseMatrix({4,5,6})
                      when i=2;
                      reverseMatrix({7,8,9})


             */
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int r = sc.nextInt();
        System.out.println("Enter the number of columns: ");
        int c = sc.nextInt();
        int [][] matrix = new int [r][c];
        System.out.println("Enter the elements of the matrix: ");
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = sc.nextInt();
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Input Matrix: ");
        printMatrix(matrix);
        clockwiseMatrix(matrix,r);
        System.out.println("Clockwise Matrix: ");
        printMatrix(matrix);
    }
}
