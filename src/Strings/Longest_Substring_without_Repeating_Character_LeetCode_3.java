package Strings;
import java.util.*;
public class Longest_Substring_without_Repeating_Character_LeetCode_3 {
    public static int lengthOfLongestSubstring(String s){
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for(int right=0;right<s.length();right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));

            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);
    }
}
