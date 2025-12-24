package Codeforce_Practice_Question;
import java.util.*;
public class Tram {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number of tram's stops: ");
            int n = sc.nextInt();
            int current = 0;
            int max = 0;
            for(int i=0;i<n;i++){
                System.out.print("Enter the values of a and b: ");
                 int a = sc.nextInt();
                 int b = sc.nextInt();
                current = current - a + b;
                max = Math.max(max, current);
            }
            System.out.println(max);
        }
    }
}
