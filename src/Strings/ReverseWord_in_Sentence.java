package Strings;
import java.util.*;
public class ReverseWord_in_Sentence {
    public static void main(String[] args) {
        String str = " I am a second year engineering student in kalinga university";
        String ans = ""; //empty string
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<=str.length()-1;i++){
            char ch = str.charAt(i);
            if(ch!=' '){
                sb.append(ch);
            }
            else{ // ch == " "
                sb.reverse();
                ans += sb;
                ans += " ";
                sb = new StringBuilder("");  // phir se sb(stringBuilder) ko empty kr diye...
            }
        }
        // till now last word is not entered into ans string because space is absent after it...and sb contain last word of the string...
//        sb.append(" "); // ye automatic phele se hi aaega...
        sb.reverse();
        ans += sb;
        System.out.println(ans);
    }
}
