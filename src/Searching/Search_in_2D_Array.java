package Searching;
import java.util.*;
public class Search_in_2D_Array {

    // Time complexity : O(log(m*n))
    static boolean searchMatrix(int[][] arr,int target){
        int n = arr.length; // number of rows
        int m = arr[0].length;  // number of columns

        int start = 0;
        int end = n * m -1;

        while(start<=end){
            int mid = start + (end-start)/2;
            int midEle = arr[mid/m][mid%m]; // formula to calculate rows and columns in 2D array....

            if(midEle == target){
                return true;
            }
            if(target < midEle){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows");
        int n = sc.nextInt();
        System.out.println("Enter the number of columns");
        int m = sc.nextInt();
        System.out.println("Enter the target");
        int target = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                arr[i][j] = sc.nextInt();
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println(searchMatrix(arr,target));
    }
}
