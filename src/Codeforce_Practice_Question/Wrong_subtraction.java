package Codeforce_Practice_Question;
import java.util.*;
public class Wrong_subtraction {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number: ");
            int n = sc.nextInt();
            System.out.println("Enter how many times to subtract: ");
            int k = sc.nextInt();
            for(int i = 1;i<=k;i++){
                int lastDigit = n % 10;
                if(lastDigit != 0){
                    n = n - 1;
                }
                if(lastDigit == 0){
                    n = n / 10;
                }
            }
            System.out.println(n);
        }
    }
}
