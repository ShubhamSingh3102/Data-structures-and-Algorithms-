package Searching;
import java.util.*;
public class Distribution_of_Chocolates {
    public static boolean isDivisionPossible(int[] arr,int m,int mxChocAllowed){
        int numOfStudent = 1;
        int chocolate = 0; // number of chocolates current student is having

        for(int i = 0;i < arr.length;i++){
            if(arr[i] > mxChocAllowed) {
                return false;
            }
            if(chocolate + arr[i] <= mxChocAllowed){
                chocolate += arr[i];
            }
            else{
                numOfStudent++;
                chocolate = arr[i];
            }
        }
        if(numOfStudent > m){
            return false;
        }
        else{
            return true;
        }
    }

    // Time complexity : O(n*log N)
    // Minimal maxima of all the division...
    public static int distribute_Chocolates(int[] arr,int m){
        if(arr.length < m){
            return -1;
        }
        int ans = 0, st = 1, end = (int)1e9;

        while(st <= end){
            int mid = st+(end-st)/2;
            if(isDivisionPossible(arr,m,mid)){ // check
                ans = mid;
                end = mid-1;
            }else{
                st = mid+1;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of boxes of chocolates");
        int n = sc.nextInt();
        System.out.println("Enter the chocolates in each boxes");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the number of students among which the chocolates are distributes");
        int m = sc.nextInt();
        int result = distribute_Chocolates(arr,m);
        System.out.println(result);
    }
}
