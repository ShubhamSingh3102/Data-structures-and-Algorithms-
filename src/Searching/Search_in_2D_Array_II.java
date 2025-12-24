package Searching;
import java.util.Scanner;
public class Search_in_2D_Array_II {
    public static boolean searchMatrixII(int[][] arr,int target){
        int n = arr.length;
        int m = arr[0].length;
        int i = 0;
        int j = m-1;

        // Space complexity : O(1)
        // Time complexity : O(m + n)

        while(i < n && j >= 0){
            if(arr[i][j] == target){
                return true;
            }
            if(target < arr[i][j]){
                j--; // we have to move left....
            }else{
                i++; // we have to move down....
            }
        }
        return false; // target not present....
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
        System.out.println(searchMatrixII(arr,target));
    }
}
