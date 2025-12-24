package Codeforce_Practice_Question;
import java.util.*;
public class Watermelon {
    public static void evenNumber(int n){
        if( n > 2 && n%2==0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();
        evenNumber(n);
    }
}
