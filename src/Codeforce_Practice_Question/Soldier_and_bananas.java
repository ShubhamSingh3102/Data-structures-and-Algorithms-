package Codeforce_Practice_Question;
import java.util.*;
public class Soldier_and_bananas {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the values of dollars for first banana: ");
            int k = sc.nextInt();
            System.out.println("Enter the values of dollars he have: ");
            int n = sc.nextInt();
            System.out.println("Enter the numbers of banana soldiers wants to buy: ");
            int w = sc.nextInt();
            int sum = 0;
            for(int i =1;i<=w;i++){
                sum = sum + k*i;
            }
            int borrow = Math.max(0,sum-n);
            System.out.println(borrow);
        }
    }
}
