package Codeforce_Practice_Question;
import java.util.*;
public class BlackSlex_and_password {
    public static class  Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the value of n: ");
            int n = sc.nextInt();
            while(n-- > 0){
                int k = sc.nextInt();
                int x = sc.nextInt();
                System.out.println((k*x)+1);
            }
        }
    }
}
