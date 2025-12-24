package Strings;
import java.util.*;
import java.lang.*;
public class ToggleString {
    public static void main(String[] args) {
        String str = "PHysiCs";
        System.out.println(str);
        //StringBuilder sb = new StringBuilder(str);
        for(int i=0;i<=str.length()-1;i++){
            boolean flag = true; // capital letter
            char ch = str.charAt(i); //A

            if(ch == ' '){
                continue;
            }
            int ascii = (int)ch; // typecasting
            if(ascii >= 97){ // small
                flag = false;
            }
            if(flag==true){ // capital
                ascii += 32;
                char dh = (char)ascii; //a
                str = str.substring(0, i) + dh + str.substring(i+1);
            }
            else{ // small
                ascii -= 32;
                char dh = (char)ascii;
                str = str.substring(0, i) + dh + str.substring(i+1);
            }
        }
        System.out.println(str);
        }
    }
