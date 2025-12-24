package Searching;
import java.util.*;
public class Sqaure_root_of_nonNegative {
    static int squareRoot(int x,int low,int high){
        int ans = -1;
        while(low <= high){
            int mid = low+(high-low)/2;
            int value = mid * mid; // use long here to avoid overflow....
//          long value = (long)mid*mid;
            if(value == x){
                return mid;
            }
            else if(value > x){
                high = mid-1;
            }
            else{
                low = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        int x = sc.nextInt();
        int result = squareRoot(x,0,x);
        System.out.println("The square root of " +x+ " is " +result);
    }
}
