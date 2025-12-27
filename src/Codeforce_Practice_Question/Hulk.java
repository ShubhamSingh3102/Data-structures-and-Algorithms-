package Codeforce_Practice_Question;
import java.util.*;
public class Hulk {
//    odd position → "I hate"
//    even position → "I love"
//    last me " it"
//    beech me " that "

    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the number: ");
            int n = sc.nextInt();
            StringBuilder str = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    str.append("I hate");
                } else {
                    str.append("I love");
                }
                if (i != n) // agar last word nahi hai
                    str.append(" that ");
                else {  // agar last word hai
                    str.append(" it");
                }
            }
            System.out.println(str.toString());
        }
    }
}
