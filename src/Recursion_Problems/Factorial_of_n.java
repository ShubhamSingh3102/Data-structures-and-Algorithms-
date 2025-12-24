package Recursion_Problems;
import java.util.*;
public class Factorial_of_n {
    static int factorial(int n){
        if(n == 1){
            return 1;
        }
        return n * factorial(n-1);
    }
    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);
    }
}
