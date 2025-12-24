package Recursion;
import java.util.*;
public class Multiple_of_n_k_times {
    public static void product(int n,int k){
        if(k == 1){
            System.out.print(n+" ");
            return;
        }
        product(n,k-1);
        System.out.print(n * k +" ");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the value of n:");
        int n = sc.nextInt();
        System.out.print("Enter the value of k:");
        int k = sc.nextInt();
        product(n,k);
    }
}
