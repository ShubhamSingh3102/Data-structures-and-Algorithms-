package Recursion_Problems;
import java.util.*;
public class Print_name_5_times {
    public static void name(String s, int n){
        // base case....
        if(n==0){
            return;
        }
        System.out.println(s);
        name(s,n-1);
    }
    public static void main(String[] args) {
       String s = "Shubham";
       name(s,5);
    }
}
