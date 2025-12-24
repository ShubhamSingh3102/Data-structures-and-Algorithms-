package Codeforce_Practice_Question;
import java.util.*;
public class Stones_on_the_table {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number: ");
            int n = sc.nextInt();
            System.out.print("Enter the color: ");
            String s = sc.next();
            int count = 0;
            for (int i = 1; i < n; i++) {
                if (s.charAt(i) == s.charAt(i - 1)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
