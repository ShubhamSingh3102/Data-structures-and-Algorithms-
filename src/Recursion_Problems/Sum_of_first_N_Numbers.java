package Recursion_Problems;
import java.util.*;
public class Sum_of_first_N_Numbers {
//    static void sum(int n,int sum){
//        if(n < 1){
//            System.out.println(sum);
//            return;
//        }
//        sum(n-1,sum+n);
    static int sum(int n){
        if(n == 0){
            return 0;
        }
        return n + sum(n-1);
    }
    public static void main(String[] args) {
//        sum(10,0);
        int result = sum(9);
        System.out.println(result);
    }
}
