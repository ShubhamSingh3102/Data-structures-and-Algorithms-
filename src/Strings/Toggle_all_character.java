package Strings;
import java.util.*;
import java.lang.*;
public class Toggle_all_character {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your string");
        // through StringBuilder....
        StringBuilder str = new StringBuilder(sc.nextLine());
        // System.out.println(str);

        // toggle
        // PHysiCs 
        for(int i=0;i<=str.length()-1;i++){
            // P -> p
            // check --> alphabet- small,capital
            boolean flag = true; // let's true means capital letter....
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
                 str.setCharAt(i, dh);
            }
            else{ // small
                ascii -= 32;
                char dh = (char)ascii;
                str.setCharAt(i, dh);
            }
        }
        System.out.println(str);
    }
}
