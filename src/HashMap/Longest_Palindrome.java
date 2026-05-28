package HashMap;
import java.util.*;
public class Longest_Palindrome {
    public static int longestPalindrome(String s){
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        int length = 0;
        boolean oddFound = false;

        for(int freq : map.values()){

            if(freq % 2 == 0){
                length += freq;
            } else {
                // odd se pair dhundo...
                length += freq -1;
                oddFound = true;
            }
        }
        if(oddFound){ // kisi ek ko bhi leke letter bana do...
            length += 1;
        }
        return length;
    }
    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}