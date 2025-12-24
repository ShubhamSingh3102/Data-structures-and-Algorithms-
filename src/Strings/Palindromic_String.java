package Strings;
import java.util.*;
import java.lang.*;
public class Palindromic_String {
    public static void main(String[] args) {
        String str = "abcdcba";


//        StringBuilder gtr = new StringBuilder(str);
//        gtr.reverse();
//        String s = gtr + ""; // string ke andar stringbuilder ko add karne ka tarika.....
//        if(str.equals(s)){
//            System.out.println("Palindrome");
//        }
//        else{
//            System.out.println("Not a palindrome");
//        }

        // Two pointer approach....
        boolean flag = true; // is palindrome
        int i = 0;
        int j = str.length()-1;
        while(i<j){
            if(str.charAt(i) != str.charAt(j)){
               flag = false;
                break;
            }
            i++;
            j--;
        }
        if(flag==true){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("Not Palindrome");
        }
    }
}
