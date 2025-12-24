package Codeforce_Practice_Question;
import java.util.*;
public class Translation {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the Berlandish word: ");
            String s = sc.next();
            System.out.print("Enter the Birlandish word: ");
            String t = sc.next();
            StringBuilder sb = new StringBuilder(s);
            if(sb.reverse().toString().equals(t)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
