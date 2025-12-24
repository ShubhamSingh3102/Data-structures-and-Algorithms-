package Recursion;
import java.util.*;
public class Sum_of_natural_number {
    public static int Sum(int n){
        if(n == 0){
            return 0;
        }
        return Sum(n-1) + n;
    }
    public static int SumSeries(int n){
        if(n == 0){
            return 0;
        }
        if((n) % 2 == 0){
            return SumSeries(n-1) - n;
        }
        else{
            return SumSeries(n-1) + n;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n = sc.nextInt();
        System.out.println(SumSeries(n));
    }
}
