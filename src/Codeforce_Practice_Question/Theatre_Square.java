package Codeforce_Practice_Question;
import java.util.*;
public class Theatre_Square {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            long least_number_needed = (long)Math.ceil((double)n / a) * (long)Math.ceil((double)m / a);
            System.out.println(least_number_needed);
        }
    }
}
