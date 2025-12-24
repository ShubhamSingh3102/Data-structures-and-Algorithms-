package Codeforce_Practice_Question;
import java.util.*;
public class String_Task {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the string");
            String str = sc.next().toLowerCase();

            String vowels = "aoyeui";
            StringBuilder sb = new StringBuilder();

            for(char c : str.toCharArray()) {
                if(vowels.indexOf(c) == -1) {       // consonant
                    sb.append('.').append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}
