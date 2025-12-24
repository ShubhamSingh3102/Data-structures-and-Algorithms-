package Recursion_Problems;
import java.util.*;
public class Check_if_a_string_is_palindrome_or_not {
    static boolean check(String s,int l,int r){
        if(l >= r){
            return true;
        }
        if(s.charAt(l) != s.charAt(r)){
            return false;
        }

        return check(s,l+1,r-1);
    }
    public static void main(String[] args) {
        String s = "madam";
        System.out.println(check(s,0,s.length()-1));
    }
}
