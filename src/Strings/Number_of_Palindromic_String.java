package Strings;
import java.util.*;
public class Number_of_Palindromic_String {
    public static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "abc";
        int count=0;
        for(int i=0;i<=str.length()-1;i++){
            for(int j=i+1;j<=str.length();j++){
                if(isPalindrome(str.substring(i,j))==true){
                    System.out.println(str.substring(i,j)+" ");
                    count++;
                }
            }
        }
        System.out.println("The number of palindromic substrings are:"+count);
    }
}
