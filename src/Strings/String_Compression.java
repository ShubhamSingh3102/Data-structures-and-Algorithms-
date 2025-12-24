package Strings;
import java.util.*;
public class String_Compression {
    public static void main(String[] args) {
        String str = "aaabbbbccddde";
        String ans = "" + str.charAt(0); // ans string is always initialise with first char of the string....
        int count = 1;
        for(int i=1;i<=str.length()-1;i++) {
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);
            if(curr==prev){
                count++;
            }
            else{
                if(count>1){
                    ans += count;
                }
                count = 1; // refreshing the value of count
                ans += curr;
            }
        }
        if(count>1) {
            ans += count;
        }
        System.out.println(ans);
    }
}
