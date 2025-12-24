package Codeforce_Practice_Question;
import java.util.*;
public class Helpful_Maths {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the character");
            String s = sc.next();

            String[] parts = s.split("\\+");

            // Convert to int and sort....
            Arrays.sort(parts);

            // Join back with '+'
            String result = String.join("+", parts);

            System.out.println(result);
        }
    }
}
