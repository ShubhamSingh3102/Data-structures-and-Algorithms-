package Codeforce_Practice_Question;
import java.util.*;
public class Petya_and_Strings {
    public static class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter the first string: ");
            String str = sc.next();
            System.out.print("Enter the second string: ");
            String ptr = sc.next();

            str = str.toLowerCase();
            ptr = ptr.toLowerCase();

            if(str.compareTo(ptr) < 0){
                System.out.println(-1);
            }
            else if(str.compareTo(ptr) > 0){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
