package Codeforce_Practice_Question;
import java.util.*;
public class Way_Too_Long_Words {
    public static class Main{
        public static void main(String args[]){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the number");
            int n = sc.nextInt();
            System.out.println("Enter the string");
            for(int i=0;i<n;i++) {
                String words = sc.next();
                if(words.length() <= 10){
                    System.out.println(words);
                }
                else{
                    System.out.println(words.charAt(0)+""+(words.length()-2)+words.charAt(words.length()-1));
                }
            }
        }
    }
}
