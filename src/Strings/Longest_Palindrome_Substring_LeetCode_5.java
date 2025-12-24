package Strings;
import java.util.*;
public class Longest_Palindrome_Substring_LeetCode_5 {
    public static String longestPalindrome(String s){
        if (s == null || s.length() < 1) {
            return "";
        }
        int n = s.length();
        String longest = "";

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String sub = s.substring(i, j + 1);
                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        return longest;
    }
    private static boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        String a = longestPalindrome(s);
        System.out.println(a);
    }
}
