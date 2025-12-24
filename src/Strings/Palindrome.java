package Strings;
import java.util.*;
public class Palindrome {
    public static int Check(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left<right){
            if (!Character.isLetterOrDigit(str.charAt(left))) {
                ++left;
            } else if (!Character.isLetterOrDigit(str.charAt(right))) {
                --right;
            if(str.charAt(left) != str.charAt(right)){
                return 0;
            }
            right--;
            left++;
        }
    }
        return 1;
    }
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        str = str.toLowerCase();
        System.out.println(Check(str));
    }
}
