package Codeforce_Practice_Question;
import java.util.*;
public class Word_to_uppercase_or_lowercase {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the string: ");
            String str = sc.next();
            int len = str.length();
            int upper = 0;
            int lower = 0;
            for(int i=0;i<len;i++){
                char ch = str.charAt(i);
                if(ch >= 'A' && ch <= 'Z'){
                    upper++;
                }
                if(ch >= 'a' && ch <= 'z'){
                    lower++;
                }
            }
            if(upper > lower){
                System.out.println(str.toUpperCase());
            }
            else if(lower > upper){
                System.out.println(str.toLowerCase());
            }
            else{
                System.out.println(str.toLowerCase());
            }
        }
    }
}
