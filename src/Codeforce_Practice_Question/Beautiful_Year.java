package Codeforce_Practice_Question;
import java.util.*;
public class Beautiful_Year {
    public static class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            int year = n + 1;
            while (true) {
                int a = year / 1000;
                int b = (year / 100) % 10;
                int c = (year / 10) % 10;
                int d = year % 10;

                if (a != b && a != c && a != d && b != c && b != d && c != d) {
                    System.out.println(year);
                    break;
                }
                year++;
            }
        }
    }
}