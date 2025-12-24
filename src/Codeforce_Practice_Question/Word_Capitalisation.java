package Codeforce_Practice_Question;
import java.util.*;
public class Word_Capitalisation {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the word");
            String s = sc.next();
            String result = Character.toUpperCase(s.charAt(0)) + s.substring(1);
            System.out.println(result);
        }
    }
}
