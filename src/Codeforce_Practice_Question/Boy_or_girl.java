package Codeforce_Practice_Question;
import java.util.*;import java.util.*;
public class Boy_or_girl {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Set<Character> set = new HashSet<>();
            System.out.println("Enter the username");
            String username = sc.next();
            for(int i=0;i<username.length();i++){
                set.add(username.charAt(i));
            }
            if(set.size() % 2 != 0){ // odd
                System.out.println("IGNORE HIM!\n");
            }
            else{
                System.out.println("CHAT WITH HER!\n");
            }
        }
    }
}
