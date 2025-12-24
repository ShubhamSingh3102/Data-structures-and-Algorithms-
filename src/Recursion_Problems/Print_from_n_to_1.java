package Recursion_Problems;
import java.util.*;
public class Print_from_n_to_1 {
    static void print(int i,int n){
        if(i>n){
            return;
        }
        print(i+1,n);
        System.out.println(i);
    }
    public static void main(String[] args) {
        print(1,10);
    }
}
